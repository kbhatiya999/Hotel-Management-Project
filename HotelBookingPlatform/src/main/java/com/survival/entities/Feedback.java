package com.survival.entities;

public class Feedback {

	private Integer bookingID;
	private Double hotelRating;
	private String feedbackDescription;
	
	public Feedback(Integer id, Double rating, String description) {
		this.bookingID = id;
		this.hotelRating = rating;
		this.feedbackDescription = description;
	}

	public Integer getBookingID() {
		return bookingID;
	}

	public Double getHotelRating() {
		return hotelRating;
	}

	public String getFeedbackDescription() {
		return feedbackDescription;
	}
	
}
