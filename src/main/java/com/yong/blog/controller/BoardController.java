package com.yong.blog.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.yong.blog.auth.PrincipalDetail;

@Controller
public class BoardController {
	
	@GetMapping({"","/"})
	public String index() {
//		System.out.println(principal.getUsername());
		return "index";
	}
}
