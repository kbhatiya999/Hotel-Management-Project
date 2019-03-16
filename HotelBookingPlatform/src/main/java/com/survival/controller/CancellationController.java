package com.survival.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.survival.service.CancellationServiceImpl;



@Controller
public class CancellationController {
	@Autowired
	CancellationServiceImpl cancellationServiceImpl;
	@RequestMapping("/")
 	public ModelAndView showCancelMenu(){
 		ModelAndView mv=new ModelAndView();
 	   mv.setViewName("cancelBooking");
 		return mv;
 	}
	
	@RequestMapping("/cancel")
 	public ModelAndView confirmCancelBooking(@RequestParam("reservationId") int reservationId){
 		ModelAndView mv=new ModelAndView();
 		boolean result=false;
 		try {
			 result=cancellationServiceImpl.isCancelled(reservationId);
		} 
 		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 	   mv.addObject("cancelValue", result);
 	   mv.setViewName("cancelResult");
 		return mv;
 	}
}
