package com.survival.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.survival.dbutils.DatabaseUtils;
import com.survival.entities.Hotel;

public class HotelDaoImpl implements HotelDao {

	
	private Connection conn;
	private DatabaseUtils db;
	
	public HotelDaoImpl() {
		db=new DatabaseUtils();
		conn=db.getConn();
	}
	
	
	
	
	
	
	
	
	@Override
	public boolean insertHotel(Hotel hotel) throws SQLException {
		PreparedStatement pState = conn.prepareStatement("INSERT INTO HOTELS VALUES (?,?,?,?,?,?,?)");
		pState.setInt(1, hotel.getHotelID());
		pState.setString(2, hotel.getHotelCity());
		pState.setString(3, hotel.getHotelName());
		pState.setDouble(4, hotel.getHotelRating());
		pState.setString(5, hotel.getHotelAddress());
		pState.setInt(6, hotel.getNumOfRoomsInHotel());
		pState.setDouble(7, hotel.getHotelDiscount());
		pState.setInt(8, hotel.getNumOfFeedback());
		return pState.executeUpdate() > 0;
	}

	@Override
	public boolean deleteHotel(String hotelName) throws SQLException {
		PreparedStatement pState = conn.prepareStatement("DELETE FROM HOTELS WHERE HNAME=?");
		pState.setString(1, hotelName);
		return pState.executeUpdate() > 0;
	}

	@Override
	public Hotel searchHotel(String hotelName) throws SQLException {
		Statement state = conn.createStatement();
		ResultSet rSet = state.executeQuery("SELECT * FROM HOTELS WHERE HNAME="+hotelName);
		return new Hotel(rSet.getInt("HID"), rSet.getString("CITY"), rSet.getString("HNAME"), rSet.getDouble("HOTELRATING"), rSet.getString("ADDRESS"), rSet.getInt("TOTALROOMS"), rSet.getDouble("DISCOUNT"),rSet.getInt("NOOFFEEDBACK"));
	
	}

	@Override
	public ResultSet getAllHotels() throws SQLException {
		Statement state = conn.createStatement();
		return state.executeQuery("SELECT * FROM HOTELS");
	
	}

}
