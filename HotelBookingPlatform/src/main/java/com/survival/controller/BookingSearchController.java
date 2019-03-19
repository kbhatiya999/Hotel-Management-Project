package com.survival.controller;


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
	public ModelAndView searchBookings(){
		ModelAndView mv = new ModelAndView();
		mv.addObject("command",new User());
		mv.setViewName("/BookingManagementSearch");   
		return mv;
	}
	
	@RequestMapping("/search")
	public  ModelAndView Search(@ModelAttribute User user){
	
		ModelAndView mv = new ModelAndView();
		
		try {
	    User user1=bookingtManagementService.validateUser(user.getUser_Name(),user.getPhone_Number());
	    userCheck=user1;
		if(user1!=null) {
			mv.addObject("cmd",user1);
			mv.setViewName("/BookingManagementSuccess");
		}
		
		else {
			mv.addObject("username",user.getUser_Name());
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
		User user1=bookingtManagementService.validateUser(userCheck.getUser_Name(),userCheck.getPhone_Number());
		mv.addObject("BookingDetailsList", bookingtManagementService.getActiveBookings(user1.getU_Id()));
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
			User user1=bookingtManagementService.validateUser(userCheck.getUser_Name(),userCheck.getPhone_Number());
			mv.addObject("BookingDetailsList", bookingtManagementService.getInactiveBookings(user1.getU_Id()));
			mv.setViewName("/InactiveBookings");
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		return mv;
	}
	
	@RequestMapping("/update_Name")
	public ModelAndView update_Name() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("/UpdateName");
		return mv;
	}
	
	@RequestMapping("/update_Phone")
	public ModelAndView update_Phone() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("/UpdatePhone");
		return mv;
	}
	
	@RequestMapping("/update_Email")
	public ModelAndView update_Email() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("/UpdateEmail");
		return mv;
	}
	
	@RequestMapping("/updateName")
	public ModelAndView updateName(@RequestParam("name") String name,@RequestParam("phone") long phone,@RequestParam("newName") String newName)
	{
		ModelAndView mv=new ModelAndView();
		try {
			boolean flag=bookingtManagementService.updateName(name, phone, newName);
			if(flag)
				mv.setViewName("/UpdateSuccessful");
			else
				mv.setViewName("/UpdateFailure");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mv;
	}
	
	@RequestMapping("/updatePhone")
	public ModelAndView updatePhone(@RequestParam("name") String name,@RequestParam("phone") long phone,@RequestParam("newPhone") long newPhone)
	{
		ModelAndView mv=new ModelAndView();
		try {
			boolean flag=bookingtManagementService.updatePhone(name, phone, newPhone);
			if(flag)
				mv.setViewName("/UpdateSuccessful");
			else
				mv.setViewName("/UpdateFailure");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mv;
	}
	

	@RequestMapping("/updateEmail")
	public ModelAndView updateEmail(@RequestParam("name") String name,@RequestParam("phone") long phone,@RequestParam("newEmail") String email)
	{
		ModelAndView mv=new ModelAndView();
		try {
			boolean flag=bookingtManagementService.updateEmail(name, phone, email);
			if(flag)
				mv.setViewName("/UpdateSuccessful");
			else
				mv.setViewName("/UpdateFailure");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mv;
	}
	


}
