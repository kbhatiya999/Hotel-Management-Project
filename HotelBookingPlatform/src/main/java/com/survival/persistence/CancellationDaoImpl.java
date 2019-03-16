package com.survival.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.survival.utils.DbConnectionHelper;

@Repository
public class CancellationDaoImpl implements CancellationDao {

	@Override
	public int isCancelled(int reservationId)  throws ClassNotFoundException,SQLException{
		Connection connection = DbConnectionHelper.getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("UPDATE Reservation SET status = ? WHERE reservationId = ?");
		preparedStatement.setString(1, "cancelled");
		preparedStatement.setInt(2, reservationId);
		int result=preparedStatement.executeUpdate();  
		connection.close();
		return result;
	}
	
}
