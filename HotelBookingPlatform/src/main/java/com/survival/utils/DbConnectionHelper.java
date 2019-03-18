package com.survival.utils;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectionHelper {

	public static Connection getConnection(){
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","tiger");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
}
