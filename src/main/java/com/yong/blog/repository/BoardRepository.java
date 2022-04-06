package com.yong.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.yong.blog.model.Board;
import com.yong.blog.model.User;

//Automatically register to bean

//@Repository(omit)
public interface BoardRepository extends  JpaRepository<Board,Integer> {
	
	
}
