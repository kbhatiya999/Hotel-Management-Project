package com.survival.persistence;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.survival.entities.Feedback;
import com.survival.utils.JDBCConnection;

public class HotelBookingTestSuite {

	private FeedbackDao fbd;
	@Before
	public void setUp() throws Exception {
		fbd= new FeedbackDaoImpl();
	}

	@After
	public void tearDown() throws Exception {
		fbd = null;
	}

	@Test
	public void test() throws SQLException, ClassNotFoundException {
		Connection connection= JDBCConnection.getConnection();
		
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM FEEDBACK");
		ResultSet resultSet = preparedStatement.executeQuery();
		
		ArrayList<Feedback> result= new ArrayList<>();
		
		while(resultSet.next()) {
			Feedback fb = new Feedback(resultSet.getInt(1),resultSet.getInt(2),resultSet.getInt(4),resultSet.getString(3));
			result.add(fb);
			
		}
		
		assertEquals("Matched", result, fbd.seeAllFeedback());
		connection.close();
	}

}
