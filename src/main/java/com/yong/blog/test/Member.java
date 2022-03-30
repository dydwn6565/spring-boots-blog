package com.yong.blog.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//@Getter
//@Setter
@Data  // getter setter together
@AllArgsConstructor
@NoArgsConstructor
//@RequiredArgsConstructor
public class Member {
	
	private  int id;
	private  String username;
	private  String password; //불변성 유지
	private  String email;
	
	
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public String getUsername() {
//		return username;
//	}
//	public void setUsername(String username) {
//		this.username = username;
//	}
//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}

}
