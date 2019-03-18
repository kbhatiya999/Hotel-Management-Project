

package com.survival.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.survival.entities.Hotel;
import com.survival.persistence.HotelDao;
import com.survival.persistence.HotelDaoImpl;

public class HotelServiceImpl implements HotelService {

	private HotelDao hd;
	
	public HotelServiceImpl() {
		hd=new HotelDaoImpl();
	}
	
	@Override
	public boolean enterHotel(Hotel hotel) throws SQLException {
		
		return hd.insertHotel(hotel);
	}

	@Override
	public boolean removeHotel(int hid) throws SQLException {
		// TODO Auto-generated method stub
		return hd.deleteHotel(hid);
	}

	@Override
	public Hotel findHotel(int hid) throws SQLException {
		// TODO Auto-generated method stub
		return hd.searchHotel(hid);
	}

	@Override
	public ResultSet viewAllHotel() throws SQLException {
		// TODO Auto-generated method stub
		return hd.getAllHotels();
	}

	
}
