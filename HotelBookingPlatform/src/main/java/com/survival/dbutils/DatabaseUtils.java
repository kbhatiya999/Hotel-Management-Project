package com.survival.dbutils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.survival.entities.Feedback;
import com.survival.entities.Guest;
import com.survival.entities.Hotel;
import com.survival.entities.Login;
import com.survival.entities.Package;
import com.survival.entities.Reservation;
import com.survival.entities.Room;
import com.survival.entities.User;

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

	public void end() throws SQLException {
		conn.close();
	}


}
