package com.survival.entities;

public class Room {

	private Integer roomID;
	private Integer hotelID;
	private Integer roomType;
	private Integer numOfRooms;
	private Double roomPrice;
	
	public Room(Integer rID, Integer hID, Integer rType, Integer numR, Double rPrice) {
		this.roomID = rID;
		this.hotelID = hID;
		this.roomType = rType;
		this.numOfRooms = numR;
		this.roomPrice = rPrice;
	}
	
	public Integer getRoomID() {
		return roomID;
	}

	public Integer getHotelID() {
		return hotelID;
	}

	public Integer getRoomType() {
		return roomType;
	}

	public Integer getNumOfRooms() {
		return numOfRooms;
	}

	public Double getRoomPrice() {
		return roomPrice;
	}
	
}
