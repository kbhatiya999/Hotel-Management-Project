
package com.survival.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.survival.entities.Reservation;

public interface ReservationService {

/*public Reservation searchReservation(String userEmail) throws SQLException;
		
	public ResultSet getAllReservations() throws SQLException;
	
	public boolean updateReservation(String userEmail) throws SQLException;
}
*/	
	
	public boolean bookHotel(Reservation reservation) throws SQLException;
	
	public ArrayList<Reservation> checkBooking(int u_id)throws SQLException;
	
	public ResultSet getAllBookings()throws SQLException;
	
	public boolean updateBooking(int u_id)throws SQLException;
	
	public boolean checkAvailablity(Reservation reservation)throws SQLException;
	
	public int checkNoOfBooked(int u_id)throws SQLException;
	
	
	
}

