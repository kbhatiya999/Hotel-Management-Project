package com.survival.test;

import java.sql.SQLException;

import com.survival.entities.Hotel;
import com.survival.persistence.HotelDao;
import com.survival.persistence.HotelDaoImpl;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hotel h=new Hotel(12,"Delhi","randikhana",4.0,"daed",5, 55.0,9);
		HotelDao hd=new HotelDaoImpl();
		try {
			System.out.println(hd.insertHotel(h));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
