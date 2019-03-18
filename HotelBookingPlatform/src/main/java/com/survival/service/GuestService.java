package com.survival.service;

import java.sql.SQLException;



public interface GuestService {
	public boolean enterGuest() throws SQLException;
	public int calculateBillAmount(Integer hid, Integer rtypeid) throws SQLException;
	
}
