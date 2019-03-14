package com.survival.entities;

public class Login {

	private Integer userID;
	private Boolean isActive;
	private Integer userRole;
	private String userName;
	private String userPassword;
	
	public Login(Integer id, Boolean isActiv, Integer role, String uName, String uPass) {
		this.userID = id;
		this.isActive = isActiv;
		this.userRole = role;
		this.userName = uName;
		this.userPassword = uPass;
	}

	public Integer getUserID() {
		return userID;
	}

	public Boolean getIsActive() {
		return isActive;
	}
	
	public void setIsActive(Boolean status) {
		this.isActive = status;
	}

	public Integer getUserRole() {
		return userRole;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserPassword() {
		return userPassword;
	}
	
}
