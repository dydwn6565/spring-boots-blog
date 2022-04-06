package com.yong.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//ORM -> java language(other languages too) -> mapping to the table


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity // table will be created in MYSQL with table
//@DynamicInsert // can control insert for role(not insert null value)
public class User {
	
	@Id //Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // follow the numbering strategy of connected DB
	private int id;// sequence ,auto_increment
	
	@Column(nullable = false, length = 100, unique =true)
	private String username; // id
	
	@Column(nullable = false, length = 100) //for hashcode
	private String password;
	
	@Column(nullable = false, length=50)
	private String email;
	
//	@ColumnDefault("'user'") // sholud use '
	@Enumerated(EnumType.STRING)
	private RoleType role; // will use enum admin or user
	
	private String oauth; //kakao, google
	
	@CreationTimestamp // time is inserted to the DB
	private Timestamp createDate;
}
