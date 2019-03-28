package com.springboot.chapter10.pojo;

import org.apache.ibatis.type.Alias;
import org.springframework.data.annotation.Id;

import javax.annotation.Generated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Alias("user")
public class User {
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String userName;
	private String note;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
