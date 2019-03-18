package com.survival.service;

import java.sql.SQLException;

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
	
}
