package com.yong.blog.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.yong.blog.model.User;
import com.yong.blog.repository.UserRepository;

@Service // register into Bean
public class PrincipalDetailService implements UserDetailsService   {
	
	@Autowired
	private UserRepository userRepository;
	
	//when Spring will that the login request , Spring will catch the username and password(2 variables)
	// just check username in DB
	// Spring automatically care about password
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("line 23 " +username);
		User principal = userRepository.findByUsername(username)
				.orElseThrow(()->{
					System.out.println("line 25 in principal"+username);
					return new UsernameNotFoundException("can not find the user"+username);
				});
		System.out.println("line 27 in principal");
		return new PrincipalDetail(principal); // session of securiy will be stored with user info 
	}
	
	
}
