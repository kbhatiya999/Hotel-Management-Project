package com.survival.utils;

public class Queries {

	public static String CHECK_RESERVATION = "select * from reservations where u_id=?";
	public static String CHECK_NUMEBR_OF_BOOKINGS = "select * from reservations where u_id=?";
	public static String CHECK_ROOM_AVAILABILITY = "select count(*) from reservation where status='booked' and hid=? and rtypeid=? and checkindate>=? and checkoutdate<=?";	
	public static String TOTAL_ROOMS ="SELECT TOTALNOOFROOMS FROM ROOMTYPE WHERE RTYPEID=? AND HID=?";
	public static String ADD_HOTEL = "INSERT INTO HOTEL VALUES (?,?,?,?,?,?,?,?)";
	public static String ADD_RESERVATION = "INSERT INTO RESERVATIONS VALUES (?,?,?,?,?,?,?,?,?,?)";
	public static String GET_ALL_RESERVATION = "SELECT * FROM RESERVATIONS";
	public static String UPDATE_RESERVATION = "UPDATE RESERVATIONS SET STATUS=? WHERE U_ID=?";
	public static String DELETE_HOTEL = "DELETE FROM HOTEL WHERE HID=?";
	public static String SEARCH_HOTEL = "SELECT * FROM HOTEL WHERE HID=?";
	public static String GET_ALL_HOTEL = "SELECT * FROM HOTEL";
}
