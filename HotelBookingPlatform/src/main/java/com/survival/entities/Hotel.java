package com.survival.entities;

public class Hotel {

	private Integer hotelID;
	private String hotelCity;
	private String hotelName;
	private Double hotelRating;
	private String hotelAddress;
	private Integer numOfRoomsInHotel;
	private Double hotelDiscount;
	
	public Hotel() {
		super();
	}
	
	public Hotel(Integer id, String city, String name, Double rating, String address, Integer numRooms, Double discount) {
		this.hotelID = id;
		this.hotelCity = city;
		this.hotelName = name;
		this.hotelRating = rating;
		this.hotelAddress = address;
		this.numOfRoomsInHotel = numRooms;
		this.hotelDiscount = discount;
	}

	public Integer getHotelID() {
		return hotelID;
	}

	public String getHotelCity() {
		return hotelCity;
	}

	public String getHotelName() {
		return hotelName;
	}

	public Double getHotelRating() {
		return hotelRating;
	}

	public String getHotelAddress() {
		return hotelAddress;
	}

	public Integer getNumOfRoomsInHotel() {
		return numOfRoomsInHotel;
	}

	public Double getHotelDiscount() {
		return hotelDiscount;
	}

	public void setHotelID(Integer hotelID) {
		this.hotelID = hotelID;
	}

	public void setHotelCity(String hotelCity) {
		this.hotelCity = hotelCity;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public void setHotelRating(Double hotelRating) {
		this.hotelRating = hotelRating;
	}

	public void setHotelAddress(String hotelAddress) {
		this.hotelAddress = hotelAddress;
	}

	public void setNumOfRoomsInHotel(Integer numOfRoomsInHotel) {
		this.numOfRoomsInHotel = numOfRoomsInHotel;
	}

	public void setHotelDiscount(Double hotelDiscount) {
		this.hotelDiscount = hotelDiscount;
	}
	
}
