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

//	@Override
//	public ResultSet getAllPackage(String param) throws ClassNotFoundException, SQLException {
//		try {
//			int num=Integer.parseInt(param);
//			return packageDaoImpl.getAllRecords(num);
//			
//		}catch(NumberFormatException e) {
//			return packageDaoImpl.getAllRecord(param);
//		}
//	}

	@Override
	public ResultSet getAllLocPackage(String location) throws ClassNotFoundException,SQLException {
		return packageDaoImpl.getAllRecord(location);
	}	
		
	@Override
	public ResultSet getAllPackage(int ptype) throws ClassNotFoundException, SQLException {
		return packageDaoImpl.getAllRecords(ptype);
	}
	

}
