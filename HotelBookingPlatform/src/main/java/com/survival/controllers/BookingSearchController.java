package com.survival.controllers;


import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.survival.entities.User;
import com.survival.service.BookingManagementServiceImpl;

@Controller
public class BookingSearchController {
	
	@Autowired
	BookingManagementServiceImpl bookingtManagementService;
	
	User userCheck = new User();
	
	@RequestMapping("/")
	public ModelAndView searchBookings(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		mv.addObject("command",new User());
		mv.setViewName("/BookingManagementSearch");   
		return mv;
	}
	
	@RequestMapping("/search")
	public  ModelAndView Search(@ModelAttribute User user){
	
		ModelAndView mv = new ModelAndView();
		
		try {
	    User user1=bookingtManagementService.validateUser(user.getUserFullName(),Long.parseLong(user.getUserPhoneNumber()));
	    userCheck=user1;
		if(user1!=null) {
			mv.addObject("cmd",user1);
			mv.setViewName("/BookingManagementSuccess");
		}
		
		else {
			mv.addObject("username",user.getUserFullName());
			mv.setViewName("/BookingManagementSearchFail");  
		}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     
		return mv;
	}
	
	@RequestMapping("/activeBookings")
	public ModelAndView isActive() {
		ModelAndView mv=new ModelAndView();
	try {
		User user1=bookingtManagementService.validateUser(userCheck.getUserFullName(),Long.parseLong(userCheck.getUserPhoneNumber()));
		mv.addObject("BookingDetailsList", bookingtManagementService.getActiveBookings(user1.getUserID()));
		mv.setViewName("/ActiveBookings");
	}
	catch(Exception ex)
	{
		System.out.println(ex);
	}
		return mv;
	}
	
	@RequestMapping("/isInActive")
	public ModelAndView isInactive()
	{
		ModelAndView mv=new ModelAndView();
		try {
			User user1=bookingtManagementService.validateUser(userCheck.getUserFullName(),Long.parseLong(userCheck.getUserPhoneNumber()));
			mv.addObject("BookingDetailsList", bookingtManagementService.getInactiveBookings(user1.getUserID()));
			mv.setViewName("/InactiveBookings");
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		return mv;
	}


}
