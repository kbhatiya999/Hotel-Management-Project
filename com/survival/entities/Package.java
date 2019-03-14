package com.survival.entities;

import java.util.Date;

public class Package {
	
	private Integer packageID;
	private Integer hotelID;
	private Integer packageType;
	private Integer packageNumDays;
	private Double packagePrice;
	private String packageDescription;
	private Date packageStartDate;
	private Integer packageNumOfRoomsBooked;
	
	public Package(Integer pID, Integer hID, Integer pType, Integer pNumDays, Double pPrice, String pDescr, Date startDate, Integer numRoomsBooked) {
		this.packageID = pID;
		this.hotelID = hID;
		this.packageType = pType;
		this.packageNumDays = pNumDays;
		this.packagePrice = pPrice;
		this.packageDescription = pDescr;
		this.packageStartDate = startDate;
		this.packageNumOfRoomsBooked = numRoomsBooked;
	}

	public Integer getPackageID() {
		return packageID;
	}

	public Integer getHotelID() {
		return hotelID;
	}

	public Integer getPackageType() {
		return packageType;
	}

	public Double getPackagePrice() {
		return packagePrice;
	}

	public String getPackageDescription() {
		return packageDescription;
	}

	public Integer getPackageNumDays() {
		return packageNumDays;
	}

	public Date getPackageStartDate() {
		return packageStartDate;
	}

	public Integer getPackageNumOfRoomsBooked() {
		return packageNumOfRoomsBooked;
	}

}
