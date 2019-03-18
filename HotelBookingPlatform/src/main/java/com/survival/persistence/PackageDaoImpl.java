package com.survival.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.survival.entities.Hotel;
import com.survival.entities.Package;

import org.apache.jasper.tagplugins.jstl.core.Catch;
import org.springframework.stereotype.Repository;

import com.survival.utils.DbConnectionHelper;

@Repository
public class PackageDaoImpl implements PackageDao {
	
	

	private Connection conn;
	
	public PackageDaoImpl() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			this.conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "tiger");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		

	}

	@Override
	public Package getRecord(int packageID) throws ClassNotFoundException,SQLException {

		PreparedStatement pstate = conn.prepareStatement("SELECT * FROM PACKAGE WHERE PID=?");
		
		pstate.setInt(1, packageID);
		ResultSet rSet = pstate.executeQuery();
		Package p=new Package();
			rSet.next();
			p.setPid(rSet.getInt("PID"));
			p.setPname(rSet.getString("PNAME"));
			p.setHid( rSet.getInt("HID"));
			p.setPrice( rSet.getInt("PRICE"));
			p.setDescription(rSet.getString("DESCRIPTION"));
			p.setPackagetype(rSet.getInt("PACKAGETYPE"));
			p.setCity(	rSet.getString("CITY"));
			p.setNoofdays( rSet.getInt("NOOFDAYS"));
			p.setRtypeid(rSet.getInt("RTYPEID"));
			
		return p;
	
	
	
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

	@Override
	public ResultSet getAllRecord() throws ClassNotFoundException, SQLException {
		Statement state = conn.createStatement();
		return state.executeQuery("SELECT * FROM PACKAGE");
	}

}
