package com.survival.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.survival.entities.MyBookingsPojo;
import com.survival.entities.Reservation;
import com.survival.persistence.MyBookingsDaoImpl;

@Controller
public class BookingsController {
	
	@Autowired
	MyBookingsDaoImpl myBookingsDaoImpl;
	
	
	@RequestMapping("/")
	public ModelAndView first()
	{
		ModelAndView mv=new ModelAndView();
		//ArrayList<Reservation>bookings=null;
		
		//bookings= myBookingsDaoImpl.getmyBookings(userId);
		
		mv.setViewName("myBookings");
		return mv;
	}
	
	/**
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@RequestMapping("/activeBookings")
	public ModelAndView fi() throws ClassNotFoundException, SQLException
	{
		ModelAndView mv=new ModelAndView();
		ArrayList<MyBookingsPojo>myBookings=null;
		
		myBookings=myBookingsDaoImpl.getmyActiveBookings(1);
		
		if(null!=myBookings && myBookings.isEmpty())
		{
		mv.setViewName("noActiveBookings");
		}
		else
		{
		mv.addObject("bookingsList",myBookings);
		
		mv.setViewName("myActiveBookingsFound");
		}
		return mv;
	}
	
	@RequestMapping("/inactiveBookings")
	public ModelAndView fit() throws ClassNotFoundException, SQLException
	{
		ModelAndView mv=new ModelAndView();
		ArrayList<MyBookingsPojo>myBookings=null;
		
		myBookings=myBookingsDaoImpl.getmyInactiveBookings(1);
		
		if(myBookings.isEmpty())
		{
		mv.setViewName("noInactiveBookings");
		}
		else
		{
		mv.addObject("bookingsList",myBookings);
		
		mv.setViewName("myPreviousBookingsFound");
		}
		return mv;
	}
	
	
	@RequestMapping("/modify")
	public ModelAndView fitd() throws ClassNotFoundException, SQLException
	{
		ModelAndView mv=new ModelAndView();
		
		
		
		return mv;
	}
	
	@RequestMapping("/cancel")
	public ModelAndView fitdd() throws ClassNotFoundException, SQLException
	{
		ModelAndView mv=new ModelAndView();
		
		return mv;
	}

}
