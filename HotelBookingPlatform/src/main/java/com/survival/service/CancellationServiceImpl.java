package com.survival.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survival.persistence.CancellationDao;
import com.survival.utils.CancellationSlab;


@Service
public class CancellationServiceImpl implements CancellationService {
	
@Autowired
CancellationDao cancellationDao;

	@Override
	public boolean isCancelled(int reservationId, int userId) throws ClassNotFoundException, SQLException {
		boolean isValidBooking=false,result=false;
		isValidBooking=cancellationDao.isValidUser(userId, reservationId);
		
		if(isValidBooking)
		{
		LocalDate cancelDate =LocalDate.now();
		LocalDate checkInDate=cancellationDao.getCheckInDate(reservationId);
		int noOfDaysBetween = (int) ChronoUnit.DAYS.between(cancelDate, checkInDate);
		if(noOfDaysBetween<=0)
			return false;
		int chargeSlab=CancellationSlab.chargeSlab(noOfDaysBetween);
		int i=cancellationDao.isCancelled(reservationId, cancelDate, chargeSlab);
		if(i>0)
			result=true;
		}
		return result;
	}

}
