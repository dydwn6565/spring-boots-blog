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
	
	
//	@Transactional(readOnly = true)// transaction will start with Select, transaction will be end when service is finished
//	public User login(User user) {
//		
//			return userRepositoty.findByUsernameAndPassword(user.getUsername(),user.getPassword());
//			
//	}
	
	
}
