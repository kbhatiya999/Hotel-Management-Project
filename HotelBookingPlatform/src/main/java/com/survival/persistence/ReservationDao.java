
package com.survival.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.survival.entities.Reservation;

public interface ReservationDao {

	public boolean insertReservation(Reservation reservation) throws SQLException;
	
	public ArrayList<Reservation> searchAllReservation(int u_id) throws SQLException;
		
	public int noOfReservation(int u_id) throws SQLException;
	public ResultSet getAllReservations() throws SQLException;
	
	public boolean updateReservation(int id) throws SQLException;
	
	public boolean checkAvailable(Reservation reservation)throws SQLException;
}
