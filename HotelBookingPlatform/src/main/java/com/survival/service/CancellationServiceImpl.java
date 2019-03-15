package com.survival.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survival.dbutils.CancellationDao;

@Service
public class CancellationServiceImpl implements CancellationService {
	
@Autowired
CancellationDao cancellationDao;

	@Override
	public boolean isCancelled(int reservationId) throws ClassNotFoundException, SQLException {
		int i=cancellationDao.isCancelled(reservationId);
		boolean result=false;
		if(i>0)
			result=true;
		return result;
	}

}
