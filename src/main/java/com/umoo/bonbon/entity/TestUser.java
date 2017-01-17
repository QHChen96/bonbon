package com.umoo.bonbon.entity;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;


public class TestUser implements Serializable{
	private static final long serialVersionUID = -353249189438903174L;

	@NotBlank
	private String username;
	
	@NotBlank
	private String password;
	
	@Max(50) @Min(1)
	private Integer age;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
}
