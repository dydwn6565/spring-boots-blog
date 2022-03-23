package com.yong.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TempControllerTest {
    
	@GetMapping("/temp/home")
	public String tempHome() {
		//file return base path: src/main/resources/static
		//return name: /home/html
		// full path: src/main/resources/static/home.html
		// Spring boots can not find jsp file(should store readable file in src/main/resources/static))
		
		return "/home.html";
	}
	
	@GetMapping("/temp/jsp")
	public String temphome() {
		return "test";
	}
}
