package com.yong.blog.controller;



import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yong.blog.model.KakaoProfile;
import com.yong.blog.model.OAuthToken;
import com.yong.blog.model.User;
import com.yong.blog.service.UserService;

@Controller
public class UserController {
	
	@Value("${cos.key}")
	private String cosKey;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/auth/signupForm")
	public String signupForm() {
		return "user/signupForm";
	}
	
	@GetMapping("/auth/loginForm")
	public String loginForm() {
		return "user/loginForm";
	}
	
	@GetMapping("/user/userInfo")
	public String updateForm() {
		return "user/updateForm";
	}
	
	@GetMapping("/auth/kakao/callback")
	public @ResponseBody String kakaoCallback(String code) { // this will be the function which returns data
		
		//post method key=value data request(to Kakao)
		// HttpsURLConnection is used in Java
		// Retrofit2 - android
		// OkHttp
		// RestTemplate
		
		RestTemplate rt= new RestTemplate(); 
		
		//httpHeader object creates
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type","application/x-www-form-urlencoded;charset=utf-8");
		
		// httpbody object creates
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("grant_type", "authorization_code");
		params.add("client_id", "1f23b831921a9a58f1e549c6e1e18fe0");
		params.add("redirect_uri", "http://localhost:8000/auth/kakao/callback");
		params.add("code", code);
		
		// HttpHeader and HttpBody are put into one object
		HttpEntity<MultiValueMap<String,String>> kakaoTokenRequest =
				new HttpEntity<>(params,headers);
		
//		exchange requires HttpEntity
		ResponseEntity<String> response = rt.exchange(
					"https://kauth.kakao.com/oauth/token",
				     HttpMethod.POST,
				     kakaoTokenRequest,
				     String.class
				);
			
		//Gson, Json simple, ObjectMapper ( library)
		ObjectMapper objectMapper = new ObjectMapper();
		OAuthToken oauthToken =null;
		
			try {
				oauthToken = objectMapper.readValue(response.getBody(),OAuthToken.class);
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
//			System.out.println("oauthToken"+response.getBody());
//			System.out.println("oauthToken"+oauthToken);
			RestTemplate rtSecond= new RestTemplate(); 
			
			//httpHeader object creates
			HttpHeaders headersSecond = new HttpHeaders();
			headersSecond.add("Authorization","Bearer "+oauthToken.getAccess_token());
			headersSecond.add("Content-type","application/x-www-form-urlencoded;charset=utf-8");
			
			HttpEntity<MultiValueMap<String,String>> kakaoProfileRequest =
					new HttpEntity<>(headersSecond);
		
			ResponseEntity<String> responseSecond = rtSecond.exchange(
					"https://kapi.kakao.com/v2/user/me",
				     HttpMethod.POST,
				     kakaoProfileRequest,
				     String.class
				);
			ObjectMapper objectMappertwo = new ObjectMapper();
			KakaoProfile kakaoProfile =null;
			
				try {
					kakaoProfile = objectMappertwo.readValue(responseSecond.getBody(),KakaoProfile.class);
				} catch (JsonMappingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JsonProcessingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			// user object = username, password,email
//			System.out.println("kakao id"+kakaoProfile.getId());
//			System.out.println("kakao email"+kakaoProfile.getKakao_account().getEmail());
			
			
			
			User kakaoUser = User.builder().username(kakaoProfile.getKakao_account().getEmail()+"_"+kakaoProfile.getId())
					.password(cosKey)
					.email(kakaoProfile.getKakao_account().getEmail())
					.oauth("kakao")
					.build();
			
			User originUser = userService.findUser(kakaoUser.getUsername());
			
			if(originUser.getUsername() == null) {
				
				userService.signup(kakaoUser);	
			}
			
			Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(kakaoUser.getUsername(),cosKey));
			SecurityContextHolder.getContext().setAuthentication(authentication);
		
			
		return "redirect:/";
	}
}
