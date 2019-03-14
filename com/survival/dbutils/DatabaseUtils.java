package com.survival.dbutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.survival.entities.Feedback;
import com.survival.entities.Hotel;

public class DatabaseUtils {

	// USAGE EXAMPLE :
	// DatabaseUtils dbUtils = new DatabaseUtils();
	// dbUtils.getAllBookings();
	// dbUtils.end();

	private Connection conn;

	public DatabaseUtils() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			this.conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "tiger");
		}
		catch(ClassNotFoundException | SQLException exc) {
			exc.printStackTrace();
		}
	}
	
	// To use connection if necessary
	public Connection getConn() { return conn; }

	// FEEDBACK START

	public boolean insertFeedback(Feedback feedback) throws SQLException {
		PreparedStatement pState = conn.prepareStatement("INSERT INTO FEEDBACK VALUES (?,?,?)");
		pState.setInt(1, feedback.getBookingID());
		pState.setDouble(2, feedback.getHotelRating());
		pState.setString(3, feedback.getFeedbackDescription());
		return pState.executeUpdate() > 0;
	}

	public boolean deleteFeedback(int bookingID) throws SQLException {
		PreparedStatement pState = conn.prepareStatement("DELETE FROM FEEDBACK WHERE BID=?");
		pState.setInt(1, bookingID);
		return pState.executeUpdate() > 0;
	}

	public Feedback searchFeedback(int bookingID) throws SQLException {
		Statement state = conn.createStatement();
		ResultSet rSet = state.executeQuery("SELECT * FROM FEEDBACK WHERE BID="+bookingID);
		return new Feedback(rSet.getInt("BID"), rSet.getDouble("HRATING"), rSet.getString("FDESCRIPTION"));
	}

	public ResultSet getAllFeedback() throws SQLException {
		Statement state = conn.createStatement();
		return state.executeQuery("SELECT * FROM FEEDBACK");
	}

	// FEEDBACK END

	// HOTEL START

	public boolean insertHotel(Hotel hotel) throws SQLException {
		PreparedStatement pState = conn.prepareStatement("INSERT INTO HOTELS VALUES (?,?,?,?,?,?,?)");
		pState.setInt(1, hotel.getHotelID());
		pState.setString(2, hotel.getHotelCity());
		pState.setString(3, hotel.getHotelName());
		pState.setDouble(4, hotel.getHotelRating());
		pState.setString(5, hotel.getHotelAddress());
		pState.setInt(6, hotel.getNumOfRoomsInHotel());
		pState.setDouble(7, hotel.getHotelDiscount());
		return pState.executeUpdate() > 0;
	}

	public boolean deleteHotel(int hotelID) throws SQLException {
		PreparedStatement pState = conn.prepareStatement("DELETE FROM HOTELS WHERE HID=?");
		pState.setInt(1, hotelID);
		return pState.executeUpdate() > 0;
	}

	public Hotel searchHotel(int hotelID) throws SQLException {
		Statement state = conn.createStatement();
		ResultSet rSet = state.executeQuery("SELECT * FROM HOTELS WHERE HID="+hotelID);
		return new Hotel(rSet.getInt("HID"), rSet.getString("HCITY"), rSet.getString("HNAME"), rSet.getDouble("HRATING"), rSet.getString("HADDR"), rSet.getInt("HNUMROOM"), rSet.getDouble("HDISCOUNT"));
	}

	public ResultSet getAllHotels() throws SQLException {
		Statement state = conn.createStatement();
		return state.executeQuery("SELECT * FROM HOTELS");
	}

	// HOTEL END
	
	public void end() throws SQLException {
		conn.close();
	}


}
