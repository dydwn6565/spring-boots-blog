package com.yong.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.yong.blog.auth.PrincipalDetailService;

// Bean register : the objects can be managed in spring container

@Configuration  // Register into Bean( loc management)
@EnableWebSecurity // add security filter
@EnableGlobalMethodSecurity(prePostEnabled=true) // when the page is accessed with specific address, authority and authentication will be checked 
public class SecurityConfig extends WebSecurityConfigurerAdapter  {
	
	@Autowired
	private PrincipalDetailService principalDetailService;
	
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}

	@Bean   //loc
	public BCryptPasswordEncoder encodePWD() {
//		String encPassword = new BCryptPasswordEncoder().encode(null);
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(principalDetailService).passwordEncoder(encodePWD());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
		.csrf().disable()   // csrf token inactive
		.authorizeRequests()
		.antMatchers("/auth/**","/js/**","/css/**","/image/**","/","/loginForm","/signupForm","/loginProc","/api/**")
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.formLogin()
		.loginPage("/auth/loginForm")
		.loginProcessingUrl("/auth/loginProc")
		.defaultSuccessUrl("/");
	}
}
