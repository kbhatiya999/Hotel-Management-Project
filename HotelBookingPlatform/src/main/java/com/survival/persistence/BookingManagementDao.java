package com.survival.persistence;

import java.sql.SQLException;
import java.util.ArrayList;

import com.survival.entities.BookingDetails;
import com.survival.entities.User;

public interface BookingManagementDao {
	
	public User validateUser(String username,long phoneNo) throws SQLException;
	public ArrayList<BookingDetails> getActivetBookings(int user_Id) throws SQLException;
	public ArrayList<BookingDetails> getInactivetBookings(int user_Id) throws SQLException;
	public boolean updateName(int user_id,String name) throws SQLException;
	public boolean updateEmail(int user_id,String email) throws SQLException;
	public boolean updatePhone(int user_id,long phone)throws SQLException;

}
