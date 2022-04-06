package com.yong.blog.controller.api;

//import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yong.blog.auth.PrincipalDetail;
import com.yong.blog.dto.ReplySaveRequestDto;
import com.yong.blog.dto.ResponseDto;
import com.yong.blog.model.Board;
import com.yong.blog.model.Reply;
import com.yong.blog.model.RoleType;
import com.yong.blog.model.User;
import com.yong.blog.service.BoardService;
import com.yong.blog.service.UserService;

@RestController 
public class BoardApiController {
	
	@Autowired
	private BoardService boardService;
	
	@PostMapping("/api/board")
	public ResponseDto<Integer>  write(@RequestBody Board board, @AuthenticationPrincipal PrincipalDetail principal) {
		boardService.write(board,principal.getUser());
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	
	// better to use controller with creating dto
	@PostMapping("/api/board/{boardId}/reply")
	public ResponseDto<Integer>  replySave(@RequestBody ReplySaveRequestDto replySaveRequestDto){
		
		boardService.writeComment(replySaveRequestDto);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	
	
	
	@DeleteMapping("/api/board/{id}")
	public ResponseDto<Integer> deleteById(@PathVariable int id){
		boardService.deleteWrite(id);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	
	@PutMapping("/api/board/{id}")
	public ResponseDto<Integer> update(@PathVariable int id, @RequestBody Board board){
		boardService.fixWrite(id,board);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	
	@DeleteMapping("/api/board/{boardId}/reply/{replyId}")
	public ResponseDto<Integer> replyDelete(@PathVariable int replyId){
		boardService.deleteComment(replyId);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
}
