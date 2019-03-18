package com.survival.entities;

public class User {

	private Integer userID;
	private String userAddress;
	private String userPhoneNumber;
	private String userFullName;
	private String userType;
	private String userEmail;
	
	public User(Integer id, String address, String phoneNumber, String fullName, String type, String email) {
		this.userID = id;
		this.userAddress = address;
		this.userPhoneNumber = phoneNumber;
		this.userFullName = fullName;
		this.userType = type;
		this.userEmail = email;
	}
	
	public User()
	{
		
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}

	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}

	public String getUserFullName() {
		return userFullName;
	}

	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}

	public  String getUserType() {
		return userType;
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", userAddress=" + userAddress + ", userPhoneNumber=" + userPhoneNumber
				+ ", userFullName=" + userFullName + ", userType=" + userType + ", userEmail=" + userEmail + "]";
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	
}
