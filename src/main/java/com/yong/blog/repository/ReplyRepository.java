package com.yong.blog.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.yong.blog.dto.ReplySaveRequestDto;
import com.yong.blog.model.Reply;

public interface ReplyRepository extends JpaRepository<Reply,Integer> {
			
	@Modifying
	@Query (value="INSERT INTO reply(userId,boardId,content,createDate) VALUES(?1,?2,?3,now()",nativeQuery=true)
	int mySave(int userid, int boardId, String content);
	
	
}
