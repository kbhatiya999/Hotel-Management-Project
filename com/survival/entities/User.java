package com.survival.entities;

public class User {

	private Integer userID;
	private String userAddress;
	private String userPhoneNumber;
	private String userFullName;
	private Integer userType;
	private String userEmail;
	
	public User(Integer id, String address, String phoneNumber, String fullName, Integer type, String email) {
		this.userID = id;
		this.userAddress = address;
		this.userPhoneNumber = phoneNumber;
		this.userFullName = fullName;
		this.userType = type;
		this.userEmail = email;
	}

	public Integer getUserID() {
		return userID;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}

	public String getUserFullName() {
		return userFullName;
	}

	public Integer getUserType() {
		return userType;
	}

	public String getUserEmail() {
		return userEmail;
	}

}
