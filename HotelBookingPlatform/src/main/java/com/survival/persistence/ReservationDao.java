
package com.survival.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.survival.entities.Reservation;

public interface ReservationDao {

	public boolean insertReservation(Reservation reservation) throws SQLException;
	
	public Reservation searchReservation(String userEmail) throws SQLException;
		
	public ResultSet getAllReservations() throws SQLException;
	
	public boolean updateReservation(String userEmail) throws SQLException;
}
