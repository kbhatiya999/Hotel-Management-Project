package com.survival.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survival.entities.Hotel;
import com.survival.persistence.HotelDao_Impl;

@Service
public class HotelService_Impl implements HotelService {
	
	@Autowired
	HotelDao_Impl hDao;

	public Boolean addHotel(Hotel hotel) throws SQLException {
		return hDao.insert(hotel);
	}

	public Boolean delHotel(String hotelName) throws SQLException {
		return hDao.delete(hotelName);
	}

	public Hotel findHotel(String hotelName) throws SQLException {
		return hDao.search(hotelName);
	}

	public LinkedList<Hotel> allTheHotels() throws SQLException {
		LinkedList<Hotel> retVal = new LinkedList<Hotel>();
		ResultSet rSet = hDao.getAll();
		while (rSet.next()) {
			Hotel currHotel = new Hotel(rSet.getInt(0), rSet.getString(1), rSet.getString(2), rSet.getDouble(3), rSet.getString(4), rSet.getInt(5), rSet.getDouble(6), rSet.getInt(7));
			retVal.add(currHotel);
		}
		return retVal;
	}


}
