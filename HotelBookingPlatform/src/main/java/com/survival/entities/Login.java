package com.survival.entities;

public class Login {

	private Integer u_Id;
	private Boolean isActive;
	private String login_Role;
	private String login_Id;
	private String login_Password;

//	create table login (u_Id number(10), is_Active number(1), login_Role varchar2(3), login_Id varchar2(20) , login_Password varchar2(16), 
//			  constraint login_pk primary key(login_Id), constraint login_fk foreign key (u_Id) references userdb1(u_Id));
	
	public Login(Integer u_Id, Boolean isActive, String login_Role, String login_Id, String login_Password) {
		super();
		this.u_Id = u_Id;
		this.isActive = isActive;
		this.login_Role = login_Role;
		this.login_Id = login_Id;
		this.login_Password = login_Password;
	}
	public Integer getU_Id() {
		return u_Id;
	}
	public void setU_Id(Integer u_Id) {
		this.u_Id = u_Id;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public String getLogin_Role() {
		return login_Role;
	}
	public void setLogin_Role(String login_Role) {
		this.login_Role = login_Role;
	}
	public String getLogin_Id() {
		return login_Id;
	}
	public void setLogin_Id(String login_Id) {
		this.login_Id = login_Id;
	}
	public String getLogin_Password() {
		return login_Password;
	}
	public void setLogin_Password(String login_Password) {
		this.login_Password = login_Password;
	}
	
	
}
