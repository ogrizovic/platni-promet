package com.poslovna.dto;

import com.poslovna.model.users.access.Password;

public class RegisterUserDTO {

	private String username; 
	private String email;
	@Password
	private String password;
	
	public RegisterUserDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
