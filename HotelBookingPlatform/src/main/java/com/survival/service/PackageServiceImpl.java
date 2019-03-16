package com.survival.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.survival.entities.Package;
import com.survival.persistence.PackageDaoImpl;

public class PackageServiceImpl implements PackageService {

	PackageDaoImpl packageDaoImpl=new PackageDaoImpl();
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


}
