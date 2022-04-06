package com.yong.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.yong.blog.auth.PrincipalDetail;
import com.yong.blog.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping({"","/"})
	public String index(Model model,@PageableDefault(size=3, sort="id", direction=Sort.Direction.DESC) Pageable pageable) {
		model.addAttribute("boards",boardService.writeList(pageable));
		return "index"; //view resolver with controller. can access boardservice with "board" collection
	}
	
	@GetMapping("/board/{id}")
	public String findById(@PathVariable int id,Model model) {
		model.addAttribute("board",boardService.writeDetailPage(id));
		
		return "board/detail";
	}
	
	@GetMapping("/board/{id}/updateForm")
	public String updateForm(@PathVariable int id, Model model) {
		model.addAttribute("board",boardService.writeDetailPage(id));
		return "board/updateForm";
	}
	
	@GetMapping("board/writeForm")
	public String saveForm() {
		return "board/writeForm";
	}
}
