package com.survival.testing;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.survival.service.ReservationServiceImpl;

public class ReservationServiceTesting {
	
	
	private ReservationServiceImpl obj;
	
	
	@Before
	public void setUp() throws Exception {
		obj=new ReservationServiceImpl();
	}

	@After
	public void tearDown() throws Exception {
		obj=null;
	}
	
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
