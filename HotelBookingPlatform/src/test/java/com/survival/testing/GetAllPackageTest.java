package com.survival.testing;

import static org.junit.Assert.*;

import java.sql.ResultSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.survival.service.PackageServiceImpl;

public class GetAllPackageTest {

	PackageServiceImpl packageServiceImpl;
	@Before
	public void setUp() throws Exception {
		packageServiceImpl=new PackageServiceImpl();
	}

	@After
	public void tearDown() throws Exception {
		packageServiceImpl=null;
	}
	
	@Test
	public void testGetAllPackageString() {
		try {
		ResultSet resultSet=packageServiceImpl.getAllLocPackage("Pune");
		if(resultSet!=null)
			assertEquals(true, true);
		else
			fail("Locational Search error");
		}catch (Exception e) {
			System.out.println(e);
		}
	}

	@Test
	public void testGetAllPackageInt() {
		try {
			ResultSet resultSet=packageServiceImpl.getAllPackage(1);
			if(resultSet!=null)
				assertEquals(true, true);
			else
				fail("Locational Search error");
			}catch (Exception e) {
				System.out.println(e);
			}
	}

}
