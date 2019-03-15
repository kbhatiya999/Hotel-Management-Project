package com.survival.entities;

public class Guest {

	private Integer guestID;
	private Integer bookingID;
	private String guestName;
	private String guestPhoneNumber;
	private Integer bookedNumRooms;
	private Integer guestModeOfPayment;
	private Double guestBillAmount;
	private String guestEmail;
	
	public Guest(Integer gID, Integer bID, String name, String phoneNumber, Integer bNumRooms, Integer mode, Double billAmount, String email) {
		this.guestID = gID;
		this.bookingID = bID;
		this.guestName = name;
		this.guestPhoneNumber = phoneNumber;
		this.bookedNumRooms = bNumRooms;
		this.guestModeOfPayment = mode;
		this.guestBillAmount = billAmount;
		this.guestEmail = email;
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

	public Integer getGuestModeOfPayment() {
		return guestModeOfPayment;
	}

	public Double getGuestBillAmount() {
		return guestBillAmount;
	}

	public String getGuestEmail() {
		return guestEmail;
	}
	
}
