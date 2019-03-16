package com.survival.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.survival.entities.Package;

import org.apache.jasper.tagplugins.jstl.core.Catch;
import org.springframework.stereotype.Repository;

import com.survival.utils.DbConnectionHelper;

@Repository
public class PackageDaoImpl implements PackageDao {
	
	
	Connection conn;
	@Override
	public Package getRecord(int packageID) throws ClassNotFoundException,SQLException {
		conn=DbConnectionHelper.getConnection();
		Statement state = conn.createStatement();
		ResultSet rSet = state.executeQuery("SELECT * FROM PACKAGE WHERE PID="+packageID);
		return new Package(rSet.getInt("PID"),rSet.getString("PNAME") , rSet.getInt("HID"), rSet.getInt("PPRICE"),rSet.getString("PDESCRIPTION"),rSet.getInt("PTYPE"),rSet.getString("PLOCATION"), rSet.getInt("PNUMDAYS"), rSet.getInt("RID"));
	}

	@Override
	public boolean insertRecord(Package pack) throws ClassNotFoundException,SQLException {
		PreparedStatement pState = conn.prepareStatement("INSERT INTO PACKAGE VALUES (?,?,?,?,?,?,?,?,?)");
		pState.setInt(1, pack.getPid());
		pState.setString(2, pack.getPname());
		pState.setInt(3, pack.getHid());
		pState.setDouble(4, pack.getPrice());
		pState.setString(5, pack.getDescription());
		pState.setInt(6, pack.getPackagetype());
		pState.setString(7, pack.getCity());
		pState.setInt(8, pack.getNoofdays());
		pState.setInt(9, pack.getRtypeid());
		return pState.executeUpdate() > 0;
	}

	@Override
	public boolean deleteRecord(int pID) throws ClassNotFoundException,SQLException {
		PreparedStatement pState = conn.prepareStatement("DELETE FROM PACKAGE WHERE pid=?");
		pState.setInt(1, pID);
		return pState.executeUpdate() > 0;
	}

	@Override
	public ResultSet getAllRecord(String location) throws ClassNotFoundException,SQLException {
		Statement state = conn.createStatement();
		return state.executeQuery("SELECT * FROM PACKAGES WHERE PLOCATION="+location);
	}

}
