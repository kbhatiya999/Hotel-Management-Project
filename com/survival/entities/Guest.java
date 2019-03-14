package com.survival.entities;

public class Guest {

	private Integer guestID;
	private Integer bookingID;
	private String guestName;
	private String guestPhoneNumber;
	private Integer bookedNumRooms;
	
	public Guest(Integer gID, Integer bID, String name, String phoneNumber, Integer bNumRooms) {
		this.guestID = gID;
		this.bookingID = bID;
		this.guestName = name;
		this.guestPhoneNumber = phoneNumber;
		this.bookedNumRooms = bNumRooms;
	}

	public Integer getGuestID() {
		return guestID;
	}

	public Integer getBookingID() {
		return bookingID;
	}

	public String getGuestName() {
		return guestName;
	}

	public String getGuestPhoneNumber() {
		return guestPhoneNumber;
	}

	public Integer getBookedNumRooms() {
		return bookedNumRooms;
	}
	
}
