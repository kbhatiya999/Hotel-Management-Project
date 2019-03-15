package com.survival.persistence;

import com.survival.entities.Hotel;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface HotelDao {

    public boolean insert(Hotel hotel) throws SQLException;

    public boolean delete(String hotelName) throws SQLException;

    public Hotel search(String hotelName) throws SQLException;

    public ResultSet getAll() throws SQLException;

}
