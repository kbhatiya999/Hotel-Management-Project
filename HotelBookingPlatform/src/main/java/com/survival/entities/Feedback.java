package com.survival.entities;

public class Feedback {
//	create table feedback (reservationid number(10), hid number(10), feedbackcomment varchar(200), rating number(1),
//			foreign key (reservationid) references reservation(reservationid),foreign key (hid) references hotel(hid));

	private Integer reservationid;
	private Integer hid;
	private String feedbackcomment;
	private Integer rating;
	
	public Feedback() {
		// TODO Auto-generated constructor stub
	}
	public Feedback(Integer reservationid, Integer hid, String feedbackcomment, Integer rating) {
		super();
		this.reservationid = reservationid;
		this.hid = hid;
		this.feedbackcomment = feedbackcomment;
		this.rating = rating;
	}
	public Integer getReservationid() {
		return reservationid;
	}
	public void setReservationid(Integer reservationid) {
		this.reservationid = reservationid;
	}
	public Integer getHid() {
		return hid;
	}
	public void setHid(Integer hid) {
		this.hid = hid;
	}
	public String getFeedbackcomment() {
		return feedbackcomment;
	}
	public void setFeedbackcomment(String feedbackcomment) {
		this.feedbackcomment = feedbackcomment;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	
	
}
