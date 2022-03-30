package com.yong.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.yong.blog.model.User;

//Automatically register to bean

//@Repository(omit)
public interface UserRepository extends  JpaRepository<User,Integer> {
	// JAP Naming query strategy
	// SELECT * FROM user WHERE username = ?1(first parameter) AND password =?2(second parameter) 
	//	User findByUsernameAndPassword(String username, String password);
	
	/*
	 * @Query(value="SELECT * FROM user WHERE username = ?1 AND password =?2"
	 * ,nativeQuery =true) User login(String username, String password);
	 */
	
	// SELECT * FROM user Where username =1?;
	Optional<User> findByUsername(String username);
}
