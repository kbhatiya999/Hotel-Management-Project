package com.survival.packagetest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.survival.entities.Package;
import com.survival.service.PackageServiceImpl;

public class InsertPackageTest {

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
	public void testInsertPackage() {
		Package pack=new Package(3, "Teuron Hotel", 1, 2000, "Enjoy the wonder of pune", 1, "Pune", 10, 1);
		try {
		assertEquals("Insert Error", false, packageServiceImpl.insertPackage(pack));
		}catch (Exception e) {
			
		}
	}
//	@Test
//	public void testInsertPackage2() {
//		Package pack=new Package(1, "Heuron Hotel", 1, 2000, "Enjoy the wonder of pune", 1, "Pune", 10, 1);
//		try {
//		assertEquals("Insert Error", true, packageServiceImpl.insertPackage(pack));
//		}catch (Exception e) {
//			
//		}
//	}
}
