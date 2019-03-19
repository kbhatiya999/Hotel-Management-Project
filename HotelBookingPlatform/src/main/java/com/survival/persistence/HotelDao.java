
package com.survival.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.survival.entities.Hotel;

public interface HotelDao {

	public boolean insertHotel(Hotel hotel)throws SQLException;	
	public boolean deleteHotel(Integer hid) throws SQLException;
	public Hotel searchHotel(Integer hid) throws SQLException;
	public ResultSet getAllHotels() throws SQLException;
	
}
