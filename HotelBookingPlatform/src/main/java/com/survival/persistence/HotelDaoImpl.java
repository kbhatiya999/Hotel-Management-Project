package com.survival.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.survival.entities.Hotel;
import com.survival.utils.Queries;

@Repository
public class HotelDaoImpl implements HotelDao {

	
	private Connection conn;
	
	
	public HotelDaoImpl() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "tiger");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		

	}
	
	
	
	
	
	
	
	
	@Override
	public boolean insertHotel(Hotel hotel) throws SQLException {
		PreparedStatement pState = conn.prepareStatement(Queries.ADD_HOTEL);
		pState.setInt(1, hotel.getHid());
		pState.setString(2, hotel.getCity());
		pState.setString(3, hotel.getHname());
		pState.setDouble(4, hotel.getHotelrating());
		pState.setString(5, hotel.getAddress());
		pState.setInt(6, hotel.getTotalrooms());
		pState.setDouble(7, hotel.getDiscount());
		pState.setInt(8, hotel.getNooffeedback());
		return pState.executeUpdate() > 0;
	}

	@Override
	public boolean deleteHotel(Integer hid) throws SQLException {
		PreparedStatement pState = conn.prepareStatement(Queries.DELETE_HOTEL);
		pState.setInt(1, hid);
		return pState.executeUpdate() > 0;
	}

	@Override
	public Hotel searchHotel(Integer hid) throws SQLException {
		PreparedStatement pstate = conn.prepareStatement(Queries.SEARCH_HOTEL);
		
		pstate.setInt(1, hid);
		ResultSet rSet = pstate.executeQuery();
		Hotel h=new Hotel();
			rSet.next();
			h.setAddress(rSet.getString("ADDRESS"));
			h.setCity(rSet.getString("CITY"));
			h.setDiscount(rSet.getInt("DISCOUNT"));
			h.setHid(rSet.getInt("HID"));
			h.setHname(rSet.getString("HNAME"));
			h.setHotelrating(rSet.getDouble("HOTELRATING"));
			h.setNooffeedback(rSet.getInt("NOOFFEEDBACK"));
			h.setTotalrooms(rSet.getInt("TOTALROOMS"));			
		
		return h;
	}

	@Override
	public ResultSet getAllHotels() throws SQLException {
		Statement state = conn.createStatement();
		return state.executeQuery(Queries.GET_ALL_HOTEL);
	
	}

}


