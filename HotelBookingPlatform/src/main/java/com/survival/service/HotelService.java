package com.survival.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.survival.entities.Hotel;


public interface HotelService {

	
	/*	public boolean insertHotel(Hotel hotel)throws SQLException;	
	public boolean deleteHotel(String hotelName) throws SQLException;
	public Hotel searchHotel(String hotelName) throws SQLException;
	public ResultSet getAllHotels() throws SQLException;*/
	
	/**ADD HOTEL DETAILS
	 * @param hotel
	 * @return
	 * @throws SQLException
	 */
	public boolean enterHotel(Hotel hotel) throws SQLException;
	
	/**REMOVE A HOTEL 
	 * @param hid
	 * @return
	 * @throws SQLException
	 */
	public boolean removeHotel(int hid) throws SQLException;
	
	/**SEARCH FOR A HOTEL
	 * @param hid
	 * @return
	 * @throws SQLException
	 */
	public Hotel findHotel(int hid) throws SQLException;
	
	/**DISPLAY ALL HOTELS
	 * @return
	 * @throws SQLException
	 */
	public ResultSet viewAllHotel() throws SQLException;
	
	
}

