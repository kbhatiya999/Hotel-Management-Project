package com.survival.service;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.survival.entities.*;
import com.survival.entities.Package;
public interface PackageService {

	Package getPackage(int packageID) throws ClassNotFoundException,SQLException;
	boolean insertPackage(Package pack) throws ClassNotFoundException, SQLException;
	boolean deletePackage(int pID) throws ClassNotFoundException, SQLException;
	ResultSet getAllPackage(String location) throws ClassNotFoundException, SQLException;
	ResultSet getAllPackage() throws ClassNotFoundException, SQLException;

}
