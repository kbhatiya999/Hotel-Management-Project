package com.survival.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.survival.dbutils.DatabaseUtils;
import com.survival.entities.Hotel;

public class HotelService_Impl implements HotelService {
	
	private DatabaseUtils dbutils;
	
	public HotelService_Impl() {
		this.dbutils = new DatabaseUtils();
	}

	public Boolean addHotel(Hotel hotel) throws SQLException {
		return dbutils.insertHotel(hotel);
	}

	public Boolean delHotel(String hotelName) throws SQLException {
		return dbutils.deleteHotel(hotelName);
	}

	public Hotel findHotel(String hotelName) throws SQLException {
		return dbutils.searchHotel(hotelName);
	}

	public LinkedList<Hotel> allTheHotels() throws SQLException {
		LinkedList<Hotel> retVal = new LinkedList<Hotel>();
		ResultSet rSet = dbutils.getAllHotels();
		while (rSet.next()) {
			Hotel currHotel = new Hotel(rSet.getInt(0), rSet.getString(1), rSet.getString(2), rSet.getDouble(3), rSet.getString(4), rSet.getInt(5), rSet.getDouble(6));
			retVal.add(currHotel);
		}
		return retVal;
	}


}
