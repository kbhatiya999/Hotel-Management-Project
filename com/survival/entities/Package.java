package com.survival.entities;

public class Package {
	
	private Integer packageID;
	private Integer hotelID;
	private Integer reservationID;
	private Integer packageType;
	private Integer packageNumDays;
	private Double packagePrice;
	private String packageDescription;
	private String packageLocation;
	private Integer packageNumOfRoomsBooked;
	
	public Package(Integer pID, Integer hID, Integer resID, Integer pType, Integer pNumDays, Double pPrice, String pDescr, String location, Integer numRoomsBooked) {
		this.packageID = pID;
		this.hotelID = hID;
		this.reservationID = resID;
		this.packageType = pType;
		this.packageNumDays = pNumDays;
		this.packagePrice = pPrice;
		this.packageDescription = pDescr;
		this.packageLocation = location;
		this.packageNumOfRoomsBooked = numRoomsBooked;
	}

	public Integer getPackageID() {
		return packageID;
	}

	public Integer getHotelID() {
		return hotelID;
	}

	public Integer getReservationID() {
		return reservationID;
	}

	public Integer getPackageType() {
		return packageType;
	}

	public String getPackageLocation() {
		return packageLocation;
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


	public Integer getPackageNumOfRoomsBooked() {
		return packageNumOfRoomsBooked;
	}

}
