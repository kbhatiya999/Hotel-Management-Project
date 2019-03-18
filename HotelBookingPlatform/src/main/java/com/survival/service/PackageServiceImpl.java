package com.survival.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survival.entities.Package;
import com.survival.persistence.PackageDaoImpl;

@Service
public class PackageServiceImpl implements PackageService {

	@Autowired
	PackageDaoImpl packageDaoImpl;
	
	@Override
	public Package getPackage(int packageID) throws ClassNotFoundException,SQLException {
		return packageDaoImpl.getRecord(packageID);
	}

	@Override
	public boolean insertPackage(Package pack) throws ClassNotFoundException,SQLException {
		return packageDaoImpl.insertRecord(pack);
	}

	@Override
	public boolean deletePackage(int pID) throws ClassNotFoundException,SQLException {
		return packageDaoImpl.deleteRecord(pID);
	}

	@Override
	public ResultSet getAllPackage(String location) throws ClassNotFoundException,SQLException {
		return packageDaoImpl.getAllRecord(location);
	}

	@Override
	public ResultSet getAllPackage() throws ClassNotFoundException, SQLException {
		return packageDaoImpl.getAllRecord();
	}


}
