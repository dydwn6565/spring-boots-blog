package com.yong.blog.controller.api;

//import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yong.blog.dto.ResponseDto;
import com.yong.blog.model.RoleType;
import com.yong.blog.model.User;
import com.yong.blog.service.UserService;

@RestController 
public class UserApiController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
//	@Autowired
	
//	private HttpSession session;
	
	@PostMapping("/api/signupForm")
	public ResponseDto<Integer>  signup(@RequestBody User user) {
		System.out.println("sign up success");
		int result  = userService.signup(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),result);
	}
	
	@PutMapping("/user/info/update")
	public ResponseDto<Integer> updateUserInfo(@RequestBody User user){
		userService.fixUserInfo(user);
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	
	
	
		//	public ResponseDto<Integer> login(@RequestBody User user,HttpSession session){ //session control
//		@PostMapping("/api/user/login")	
//		public ResponseDto<Integer> login(@RequestBody User user){
//		System.out.println("login");
//		User principal = userService.login(user); // principal(who are trying to access
//		if(principal != null) {
//			session.setAttribute("principal", principal);
//		}
//		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
//	}
	
	
}
