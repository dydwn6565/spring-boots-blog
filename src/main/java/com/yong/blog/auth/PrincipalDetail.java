package com.yong.blog.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.yong.blog.model.User;

// sping security take the login request and make the login process and 
// store the spring security to session storage with UserDetail type object
public class PrincipalDetail implements UserDetails {
	
	private User user; //composition
	
	public PrincipalDetail(User user) {
		this.user = user;
		
	}

	@Override
	public String getPassword() {
		
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		
		return user.getUsername();
	}

	// true : not expire
	@Override
	public boolean isAccountNonExpired() {

		return true;
	}
	
	// true: not lock
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	
	// true not expir
	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}
	
//	true : active
	@Override
	public boolean isEnabled() {

		return true;
	}
		
	//return 
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		Collection<GrantedAuthority> collectors = new ArrayList<>();
//		collectors.add(new GrantedAuthority() { 
//			
//			@Override
//			public String getAuthority() {
//
//				return "ROLE_"+user.getRole(); // ROLE_USER
//			}
//		});
		
		collectors.add(()->{  // GrantedAuthority has only one function
			return "ROLE_"+user.getRole(); // ROLE_USER
		});
		return collectors;
	}

	
	
}
