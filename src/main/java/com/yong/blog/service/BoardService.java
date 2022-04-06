package com.yong.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yong.blog.dto.ReplySaveRequestDto;
import com.yong.blog.model.Board;
import com.yong.blog.model.Reply;
import com.yong.blog.model.RoleType;
import com.yong.blog.model.User;
import com.yong.blog.repository.BoardRepository;
import com.yong.blog.repository.ReplyRepository;
import com.yong.blog.repository.UserRepository;

import lombok.RequiredArgsConstructor;

//Register into Bean Ioc
@Service
@RequiredArgsConstructor // to use final  // this is kind of an initialization for repositories in Boardservice
public class BoardService {
	
//	@Autowired
	private final BoardRepository boardRepository;
	
	@Autowired // In IOC, there are many stored repositories.
	private UserRepository userRepository;
	
//	@Autowired
	private final ReplyRepository replyRepository;
	
	@Transactional
	public void write(Board board,User user) { // title, content
		board.setCount(0);
		board.setUser(user);
		boardRepository.save(board);
	}
	
//	public List<Board> writeList(){
//		return boardRepository.findAll();
//	}
	
//	public Page<Board> writeList(Pageable pageable){
//		return boardRepository.findAll(pageable);
//	}
	
	@Transactional(readOnly=true)
	public Page<Board> writeList(Pageable pageable){
		Page<Board> pagingUser = boardRepository.findAll(pageable);
		
		return pagingUser;
}	
	
	@Transactional(readOnly=true)
	public Board writeDetailPage(int id) {
		
		return boardRepository.findById(id)
				.orElseThrow(()->{
					return new IllegalArgumentException("fail to access to detail page");
				});
	}
	
	@Transactional
	public void deleteWrite(int id) {
		boardRepository.deleteById(id);

	}
	
	@Transactional
	public void fixWrite(int id, Board requestBoard) {
		Board board = boardRepository.findById(id)
		.orElseThrow(()->{
					return new IllegalArgumentException("We can not find your write: we can not find your id");
				});
		board.setTitle(requestBoard.getTitle());
		board.setContent(requestBoard.getContent());
		// when the function is finished, also transaction will be finished. Then, duty checking starts- automatically update = db flush
	}
	
	@Transactional
	public void writeComment(ReplySaveRequestDto replySaveRequestDto) {
			
//			User user = userRepository.findById(replySaveRequestDto.getUserId()).orElseThrow(()->{
//			   return new IllegalArgumentException("fail to write : can not find id");
//		   });
//		
//		   Board board = boardRepository.findById(replySaveRequestDto.getBoardId()).orElseThrow(()->{
//			   return new IllegalArgumentException("fail to write : can not find id");
//		   });
//		   
//		   Reply reply = Reply.builder()
//				   							.user(user)
//				   							.board(board)
//				   							.content(replySaveRequestDto.getContent())
//				   							.build();
//			replyRepository.save(reply);
			
		int result =replyRepository.mySave(replySaveRequestDto.getUserId(),replySaveRequestDto.getBoardId(),replySaveRequestDto.getContent());
			
	}
	
	@Transactional
	public void deleteComment(int replyId) {
		replyRepository.deleteById(replyId);
	}
}
