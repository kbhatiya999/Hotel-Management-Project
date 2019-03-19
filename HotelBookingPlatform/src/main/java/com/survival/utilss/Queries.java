package com.survival.utilss;

public class Queries {

	
	public static String CHECK_USER = "SELECT * FROM LOGIN WHERE LOGIN_ID=?";
	
	public static String GET_USER_ROLE = "SELECT USER_ROLE FROM USERDB1 WHERE U_ID=";
	
	public static String INSERT_USER_DETAILS = "INSERT INTO USERDB1 VALUES (?,?,?,?,?,?,?)";
	
	public static String GET_USER_ID = "SELECT U_ID FROM LOGIN WHERE LOGIN_ID=?";
	
	public static String GET_TOTAL_USERS = "SELECT COUNT(U_ID) AS USERS FROM LOGIN";
	
	public static String INSERT_LOGIN_DETAILS = "INSERT INTO LOGIN VALUES (?,?,?,?,?)";
}
