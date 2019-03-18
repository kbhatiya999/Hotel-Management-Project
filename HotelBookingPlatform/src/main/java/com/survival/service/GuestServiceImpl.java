package com.survival.service;

import java.sql.SQLException;

import com.survival.entities.Hotel;



public class GuestServiceImpl implements GuestService {
	
	GuestService guestService;
	
	
	public GuestServiceImpl() {
		// TODO Auto-generated constructor stub
		guestService=new GuestServiceImpl();
	}
	@Override
	public boolean enterGuest() throws SQLException {
		// TODO Auto-generated method stub
		return guestService.enterGuest();
	}
	@Override
	public int calculateBillAmount(Integer hid, Integer rtypeid ) throws SQLException {
		// TODO Auto-generated method stub
		HotelServiceImpl hotelServiceImpl =new HotelServiceImpl();
		Hotel hotel=hotelServiceImpl.findHotel(hid);
		
		
		return 0;
	}
	
}
