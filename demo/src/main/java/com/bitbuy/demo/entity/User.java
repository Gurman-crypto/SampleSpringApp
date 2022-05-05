package com.bitbuy.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

@Entity
public class User {

	@Id
	@Column(name ="user_Id" , updatable = false )
	private long userId;

	@Pattern(regexp = "^(?:[a-zA-Z0-9]+)@(?:[a-zA-Z0-9]+)+(?:\\.[a-zA-Z]*){1,2}$" , message ="Invalid email")
	private String email;

	@Pattern(regexp = "^\\(\\+\\d\\)\\d{3}-\\d{3}-\\d{4}$" , message ="Invalid Phone No")
	private String phone;

	private String username;

	private String password;
	
	public User() {
		super();
	}

	public long getUserId() {
		return userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

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

	
}
