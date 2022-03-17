package com.yong.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//  spring will scan below com.yong.blog package and not manage all files.
// specific class files with certain annotation will be managed in spring container(Ioc)
@RestController
public class BlogControllerTest {
	
	@GetMapping("/test/hello")
	public String hello() {
		return "<h1>Hello spring boot</h1>";
	}
}
