package com.survival.persistence;

import com.survival.dbutils.DatabaseUtils;
import com.survival.entities.Hotel;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import java.sql.ResultSet;

@Repository
public class HotelDao_Impl implements HotelDao {

    private DatabaseUtils dbutils;

    public HotelDao_Impl() {
        this.dbutils = new DatabaseUtils();
	}

    public boolean insert(Hotel hotel) throws SQLException{
        return dbutils.insertHotel(hotel);
    }
//
//    public boolean delete(String hotelName) throws SQLException{
//        return dbutils.deleteHotel(hotelName);
//    }
//
//    public Hotel search(String hotelName) throws SQLException{
//        return dbutils.searchHotel(hotelName);
//    }
//
//    public ResultSet getAll() throws SQLException{
//        return dbutils.getAllHotels();
//    }

}
