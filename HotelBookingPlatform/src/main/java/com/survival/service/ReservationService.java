package com.survival.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.survival.entities.Reservation;

public interface ReservationService {

/*public Reservation searchReservation(String userEmail) throws SQLException;
		
	public ResultSet getAllReservations() throws SQLException;
	
	public boolean updateReservation(String userEmail) throws SQLException;
}
*/	
	
	public boolean bookHotel(Reservation reservation) throws SQLException;
	
	public Reservation checkBooking(String userEmail)throws SQLException;
	
	public ResultSet getAllBookings()throws SQLException;
	
	public boolean updateBooking(String userEmail)throws SQLException;
	
	
}