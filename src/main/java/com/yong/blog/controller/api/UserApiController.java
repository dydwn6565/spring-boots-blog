package com.yong.blog.controller.api;

//import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.PostMapping;
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
	
//	@Autowired
	
//	private HttpSession session;
	
	@PostMapping("auth/user/api/signupForm")
	public ResponseDto<Integer>  signup(@RequestBody User user) {
		System.out.println("sign up success");
		int result  = userService.signup(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),result);
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
