package com.survival.testing;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.survival.service.PackageServiceImpl;

public class DeletePackageTest {

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
	public void testDeletePackage() {
		try {
		assertEquals("Delete Error", true, packageServiceImpl.deletePackage(7));
		}catch (Exception e) {
			
		}
	}
	
//	@Test
//	public void testDeletePackage2() {
//		try {
//		assertEquals("Delete Error", false, packageServiceImpl.deletePackage(1));
//		}catch (Exception e) {
//			
//		}
//	}
}
