package com.poslovna.dto;

public class ChangePasswordDto {

	private String oldPassword;
	private String newPassword;
	
	public ChangePasswordDto() {
		// TODO Auto-generated constructor stub
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	
}
