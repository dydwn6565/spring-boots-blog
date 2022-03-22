package com.yong.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//사용자가 요청 -> 응답 (HTML 파일)
//@Controller


// 사용자가 요청 -> 응답(Data)
@RestController
public class HttpControllerTest {

	@GetMapping("/http/get")
	public String getTest(Member member) {
		
		return "Get request" +member.getId() +" "+member.getUsername();
	}
	
	@PostMapping("/http/post")
	public String postTest(@RequestBody Member member) {
		return "Post request"+member.getId() +" "+member.getUsername();
	}
	
	@PutMapping("/http/put")
	public String putTest() {
		return "Put Request";
	}
	
	@DeleteMapping("/http/delete")
	public String deleteTest() {
		return "Delete Request";
	}
}
