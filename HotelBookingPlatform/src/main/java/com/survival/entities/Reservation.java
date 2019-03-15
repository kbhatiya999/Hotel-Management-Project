package com.survival.entities;

import java.util.Date;

public class Reservation {

	private Integer reservationID;
	private Integer bookingID;
	private Integer userID;
	private Integer hotelID;
	private Date reservationCheckInDate;
	private Date reservationCheckOutDate;
	private Double reservationBillAmount;
	private String userEmailID;
	private Integer packageType;
	private Integer reservationStatus;
	
	public Reservation(Integer rID, Integer bID, Integer uID, Integer hID, Date rCheckIn, Date rCheckOut, Double billAmount, String uEmail, Integer pType, Integer rStatus) {
		this.reservationID = rID;
		this.bookingID = bID;
		this.userID = uID;
		this.hotelID = hID;
		this.reservationCheckInDate = rCheckIn;
		this.reservationCheckOutDate = rCheckOut;
		this.reservationBillAmount = billAmount;
		this.userEmailID = uEmail;
		this.packageType = pType;
		this.reservationStatus = rStatus;
	}

	public Integer getReservationID() {
		return reservationID;
	}

	public Integer getBookingID() {
		return bookingID;
	}

	public Integer getUserID() {
		return userID;
	}

	public Integer getHotelID() {
		return hotelID;
	}

	public Date getReservationCheckInDate() {
		return reservationCheckInDate;
	}

	public Date getReservationCheckOutDate() {
		return reservationCheckOutDate;
	}

	public Double getReservationBillAmount() {
		return reservationBillAmount;
	}

	public String getUserEmailID() {
		return userEmailID;
	}

	public Integer getPackageType() {
		return packageType;
	}

	public Integer getReservationStatus() {
		return reservationStatus;
	}
	
}
