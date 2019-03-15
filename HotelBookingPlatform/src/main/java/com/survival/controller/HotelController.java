package com.survival.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.survival.entities.Hotel;
import com.survival.service.HotelService_Impl;

@Controller
public class HotelController {
	
	@Autowired
	HotelService_Impl hService;

	@RequestMapping("/AddHotel")
	public ModelAndView addHotel() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("command", new Hotel());
		mv.setViewName("HotelAdd");
		return mv;
	}
	
	@RequestMapping("/AddHotelResult")
	public ModelAndView addHotelResult(@ModelAttribute Hotel hotel) throws SQLException {
		
		ModelAndView modelAndView =new ModelAndView();
		
		if(hService.addHotel(hotel))
		{
			modelAndView.setViewName("faliure");
		}
		else
		{
			modelAndView.setViewName("insertsuccess");
		}
		return modelAndView;
		
	} 
	
//	@RequestMapping("/EditHotel")
//	public ModelAndView editHotel() {
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("msg","Hello");
//		mv.setViewName("result");
//		return mv;
//	}
//	
//	@RequestMapping("/ViewHotel")
//	public ModelAndView viewHotel() {
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("msg","Hello");
//		mv.setViewName("result");
//		return mv;
//	}
//	
//	@RequestMapping("/DeleteHotel")
//	public ModelAndView deleteHotel() {
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("msg","Hello");
//		mv.setViewName("result");
//		return mv;
//	}
//	
//	@RequestMapping("/AddRoom")
//	public ModelAndView addRoom() {
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("msg","Hello");
//		mv.setViewName("result");
//		return mv;
//	}
//	
//	@RequestMapping("/EditRoom")
//	public ModelAndView editRoom() {
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("msg","Hello");
//		mv.setViewName("result");
//		return mv;
//	}
//	
//	@RequestMapping("/ViewRoom")
//	public ModelAndView viewRoom() {
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("msg","Hello");
//		mv.setViewName("result");
//		return mv;
//	}
//	
//	@RequestMapping("/DeleteRoom")
//	public ModelAndView deleteRoom() {
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("msg","Hello");
//		mv.setViewName("result");
//		return mv;
//	}
	
}
