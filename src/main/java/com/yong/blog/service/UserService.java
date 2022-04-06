package com.yong.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yong.blog.model.RoleType;
import com.yong.blog.model.User;
import com.yong.blog.repository.UserRepository;

//Register into Bean Ioc
@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepositoty;
	
	@Autowired
	private BCryptPasswordEncoder  encoder;
	
	@Transactional(readOnly=true)
	public User findUser(String username) {
		
		User user =userRepositoty.findByUsername(username).orElseGet(()->{
			return new User();
		});
		
		return user;
	}
	
	@Transactional
	public int signup(User user) {
		try {
			String rawPassword = user.getPassword();
			String encPassword = encoder.encode(rawPassword);
			user.setPassword(encPassword);
			user.setRole(RoleType.USER);
			userRepositoty.save(user);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("UserService: signup():"+e.getMessage());
		}
		return -1;
	}
	
	@Transactional
	public void fixUserInfo(User user) {
		//when fix it, the context user object needs to be perpetualizationed(영속화? 영속성)
		// Select User object from db 
		
		User persistance = userRepositoty.findById(user.getId()).orElseThrow(()->{
			return new IllegalArgumentException("fail to find the user");
		}) ;
		
		// Validation check
		if(persistance.getOauth() == null || persistance.getOauth().equals("")) {
			String rawPassword = user.getPassword();
			String encPassword = encoder.encode(rawPassword);
			persistance.setPassword(encPassword);
			persistance.setEmail(user.getEmail());
		}
		
		
		//  user info function is terminated = transaction is terminated = automatically commit
		// when the STS detects the change of the object , then it will do the duty checking
	}
//	@Transactional(readOnly = true)// transaction will start with Select, transaction will be end when service is finished
//	public User login(User user) {
//		
//			return userRepositoty.findByUsernameAndPassword(user.getUsername(),user.getPassword());
//			
//	}
	
	
}
