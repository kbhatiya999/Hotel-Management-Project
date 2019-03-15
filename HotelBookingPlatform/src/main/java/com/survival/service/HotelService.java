package com.survival.service;

import java.sql.SQLException;
import java.util.LinkedList;

import com.survival.entities.Hotel;

public interface HotelService {

	public Boolean addHotel(Hotel hotel) throws SQLException;
//	public Boolean delHotel(String hotelName) throws SQLException;
//	public Hotel findHotel(String hotelName) throws SQLException;
//	public LinkedList<Hotel> allTheHotels() throws SQLException;

}
