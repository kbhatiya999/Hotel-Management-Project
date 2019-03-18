package com.survival.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.survival.entities.BookingDetails;
import com.survival.entities.User;
import com.survival.persistence.BookingManagementDao;
import com.survival.persistence.BookingManagementDaoImpl;

@Service
public class BookingManagementServiceImpl implements BookingManagementService {
	
	private BookingManagementDao bookingManagementDao;
	
	public BookingManagementServiceImpl() {
		bookingManagementDao=new BookingManagementDaoImpl();
	}

	@Override
	public User validateUser(String name, long phone) throws SQLException {
		return bookingManagementDao.validateUser(name,phone);
	}

	
	@Override
	public boolean updateName(int user_id, String name) throws SQLException {
		return bookingManagementDao.updateName(user_id, name);
	}

	@Override
	public boolean updateEmail(int user_id, String email) throws SQLException {
		return bookingManagementDao.updateEmail(user_id, email);
	}

	@Override
	public boolean updatePhone(int user_id, long phone) throws SQLException {
		return bookingManagementDao.updatePhone(user_id, phone);
	}

	@Override
	public ArrayList<BookingDetails> getActiveBookings(int user_id) throws SQLException {
		return bookingManagementDao.getActivetBookings(user_id);
	}

	@Override
	public ArrayList<BookingDetails> getInactiveBookings(int user_id) throws SQLException {
		return bookingManagementDao.getInactivetBookings(user_id);
	}
	
	

}
