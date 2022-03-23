package com.yong.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yong.blog.model.User;

//Automatically register to bean

//@Repository(omit)
public interface UserRepository extends  JpaRepository<User,Integer> {

}
