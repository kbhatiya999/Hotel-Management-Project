package com.survival.entities;

public class User {
//	create table userdb1
//	(u_Id number(10), email_Id varchar2(35), user_Name varchar2(50), phone_Number number(10), 
//	user_Address varchar2(100), user_role varchar2(3),is_Active number(1), CONSTRAINT user_pk primary key(u_Id));

	private Integer u_Id;
	private String email_Id;
	private String user_Name;
	private Integer phone_Number;
	private String user_Address;
	private String user_role;
	private Boolean is_active;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(Integer u_Id, String email_Id, String user_Name, Integer phone_Number, String user_Address,
			String user_role, Boolean is_active) {
		super();
		this.u_Id = u_Id;
		this.email_Id = email_Id;
		this.user_Name = user_Name;
		this.phone_Number = phone_Number;
		this.user_Address = user_Address;
		this.user_role = user_role;
		this.is_active = is_active;
	}
	public Integer getU_Id() {
		return u_Id;
	}
	public void setU_Id(Integer u_Id) {
		this.u_Id = u_Id;
	}
	public String getEmail_Id() {
		return email_Id;
	}
	public void setEmail_Id(String email_Id) {
		this.email_Id = email_Id;
	}
	public String getUser_Name() {
		return user_Name;
	}
	public void setUser_Name(String user_Name) {
		this.user_Name = user_Name;
	}
	public Integer getPhone_Number() {
		return phone_Number;
	}
	public void setPhone_Number(Integer phone_Number) {
		this.phone_Number = phone_Number;
	}
	public String getUser_Address() {
		return user_Address;
	}
	public void setUser_Address(String user_Address) {
		this.user_Address = user_Address;
	}
	public String getUser_role() {
		return user_role;
	}
	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}
	public Boolean getIs_active() {
		return is_active;
	}
	public void setIs_active(Boolean is_active) {
		this.is_active = is_active;
	}
	
	
	
	}
