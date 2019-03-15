package com.survival.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.survival.entities.Reservation;
import com.survival.persistence.ReservationDao;
public class ReservationServiceImpl implements ReservationService {

	/*public boolean insertReservation(Reservation reservation) throws SQLException;
	
	public Reservation searchReservation(String userEmail) throws SQLException;
		
	public ResultSet getAllReservations() throws SQLException;
	
	public boolean updateReservation(String userEmail) throws SQLException;
	*/
	
	ReservationDao rd;
	
	@Override
	public boolean bookHotel(Reservation reservation) throws SQLException {
		
		return rd.insertReservation(reservation);
	}

	@Override
	public Reservation checkBooking(String userEmail) throws SQLException {
		// TODO Auto-generated method stub
		return rd.searchReservation(userEmail);
	}

	@Override
	public ResultSet getAllBookings() throws SQLException {
		// TODO Auto-generated method stub
		return rd.getAllReservations();
	}

	@Override
	public boolean updateBooking(String userEmail) throws SQLException {
		// TODO Auto-generated method stub
		return rd.updateReservation(userEmail);
	}

}
