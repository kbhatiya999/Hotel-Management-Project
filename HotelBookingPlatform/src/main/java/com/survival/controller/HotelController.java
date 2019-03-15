package com.survival.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.survival.entities.Hotel;
import com.survival.service.HotelService_Impl;

@Controller
public class HotelController {
	
	@Autowired
	HotelService_Impl hService;
	
	@RequestMapping("/")
	public ModelAndView empDashboard() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("EmployeeDashboard");
		return mv;
	}

	@RequestMapping("/AddHotel")
	public ModelAndView addHotel() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("command", new Hotel());
		mv.setViewName("HotelAdd");
		return mv;
	}
	
	@RequestMapping("/AddHotelResult")
	public ModelAndView addHotelResult(@RequestParam("hotelID") Integer hID, @RequestParam("hotelName") String hName, @RequestParam("hotelCity") String hCity, @RequestParam("hotelAddress") String hAddress, @RequestParam("numOfRoomsInHotel") Integer numRooms, @RequestParam("hotelDiscount") Double hDiscount, @RequestParam("hotelRating") Double hRating, @RequestParam("noOfFeedback") Integer numFeedback) {
		
		ModelAndView modelAndView =new ModelAndView();
		
		Hotel hotel = new Hotel(hID, hCity, hName, hRating, hAddress, numRooms, hDiscount, numFeedback);
		
		try {
			if(hService.addHotel(hotel)) {
				modelAndView.setViewName("insertsuccess");
			}
		}
		catch(SQLException exc) {
			modelAndView.setViewName("faliure");
			exc.printStackTrace();
		}
		
		return modelAndView;
		
	} 
	
//	@RequestMapping("/EditHotel")
//	public ModelAndView editHotel(@RequestParam("hotelID") Integer hID, @RequestParam("hotelName") String hName, @RequestParam("hotelCity") String hCity, @RequestParam("hotelAddress") String hAddress, @RequestParam("numOfRoomsInHotel") Integer numRooms, @RequestParam("hotelDiscount") Double hDiscount, @RequestParam("hotelRating") Double hRating, @RequestParam("noOfFeedback") Integer numFeedback) throws SQLException {
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("msg","Hello");
//		mv.setViewName("result");
//		return mv;
//	}
	
	@RequestMapping("/ViewHotel")
	public ModelAndView viewHotel() throws SQLException {
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg", hService.allTheHotels().toString());
		mv.setViewName("ViewHotel");
		return mv;
	}
	
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
