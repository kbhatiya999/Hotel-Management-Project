package com.survival.dbutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.survival.entities.Feedback;

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

	public boolean deleteCourse(int bookingID) throws SQLException {
		PreparedStatement pState = conn.prepareStatement("DELETE FROM FEEDBACK WHERE BID=?");
		pState.setInt(1, bookingID);
		return pState.executeUpdate() > 0;
	}

	public Feedback searchCourse(int bookingID) throws SQLException {
		Statement state = conn.createStatement();
		ResultSet rSet = state.executeQuery("SELECT * FROM FEEDBACK WHERE BID="+bookingID);
		return new Feedback(rSet.getInt("BID"), rSet.getDouble("HRATING"), rSet.getString("FDESCRIPTION"));
	}

	public ResultSet getAllFeedback() throws SQLException {
		Statement state = conn.createStatement();
		return state.executeQuery("SELECT * FROM FEEDBACK");
	}

	// FEEDBACK END

	public void end() throws SQLException {
		conn.close();
	}


}
