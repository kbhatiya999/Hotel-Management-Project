package com.survival.persistence;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.survival.entities.Reservation;
import com.survival.dbutils.*;
public class ReservationDaoImpl implements ReservationDao {

	private Connection conn;
	private DatabaseUtils db;
	
	public ReservationDaoImpl() {
		db=new DatabaseUtils();
		conn=db.getConn();
	}
	
	
	
	@Override
	public boolean insertReservation(Reservation reservation)throws SQLException {
		PreparedStatement pState = conn.prepareStatement("INSERT INTO RESERVATIONS VALUES (?,?,?,?,?,?,?,?,?,?)");
		pState.setInt(1, reservation.getReservationID());
		pState.setInt(2, reservation.getBookingID());
		pState.setInt(3, reservation.getUserID());
		pState.setInt(4, reservation.getHotelID());
		pState.setDate(5, (Date) reservation.getReservationCheckInDate());
		pState.setDate(6, (Date) reservation.getReservationCheckOutDate());
		pState.setDouble(7, reservation.getReservationBillAmount());
		pState.setString(8, reservation.getUserEmailID());
		pState.setInt(9, reservation.getPackageType());
		pState.setInt(10, reservation.getReservationStatus());
		return pState.executeUpdate() > 0;
		
		
	}

	@Override
	public Reservation searchReservation(String userEmail)throws SQLException {
		Statement state = conn.createStatement();
		ResultSet rSet = state.executeQuery("SELECT * FROM RESERVATIONS WHERE UEMAILID="+userEmail);
		return new Reservation(rSet.getInt("RID"),rSet.getInt("BID"), rSet.getInt("UID"),rSet.getInt("HID"), rSet.getDate("RSTARTDATE"), rSet.getDate("RENDDATE"), rSet.getDouble("RBILLAMOUNT"), rSet.getString("UEMAILID"),  rSet.getInt("PTYPE"), rSet.getInt("RRESERVATIONSTATUS"));
	
	}

	@Override
	public ResultSet getAllReservations() throws SQLException {
		Statement state = conn.createStatement();
		return state.executeQuery("SELECT * FROM RESERVATIONS");
	}

	@Override
	public boolean updateReservation(String userEmail) throws SQLException {
		PreparedStatement pState = conn.prepareStatement("UPDATE RESERVATIONS SET STATUS=? WHERE UEMAILID=?");
		pState.setString(1, "CANCELLED");
		pState.setString(2, userEmail);
		return pState.executeUpdate() > 0;	
		
		
	}

}
