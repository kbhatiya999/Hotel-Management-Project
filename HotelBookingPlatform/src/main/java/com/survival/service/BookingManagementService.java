package com.survival.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.survival.entities.BookingDetails;
import com.survival.entities.User;

public interface BookingManagementService {
	
	public User validateUser(String name,long  phone ) throws SQLException;
	public ArrayList<BookingDetails> getActiveBookings(int user_id) throws SQLException;
	public ArrayList<BookingDetails> getInactiveBookings(int user_id) throws SQLException;
	public boolean updateName(int user_id,String name) throws SQLException;
	public boolean updateEmail(int user_id,String email)throws SQLException;
	public boolean updatePhone(int user_id,long phone)throws SQLException;

}
