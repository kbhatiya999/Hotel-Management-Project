package com.survival.controller;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.survival.entities.Hotel;
import com.survival.service.HotelServiceImpl;




@Controller
public class EmployeeController {


	@Autowired
	HotelServiceImpl hService;
	
	@RequestMapping("/")
	public ModelAndView empDashboard() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("command",new Hotel());
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
	public ModelAndView insertResult(@ModelAttribute Hotel hotel) {
		
		ModelAndView modelAndView =new ModelAndView();
		
		try {
			if(hService.enterHotel(hotel))
			{
				modelAndView.setViewName("insertsuccess");
			}
			else
			{
				modelAndView.setViewName("failure");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modelAndView;
	}
	@RequestMapping("/DeleteHotel")
	public ModelAndView delete()
	{
		ModelAndView mv= new ModelAndView();
		mv.addObject("command",new Hotel());
		mv.setViewName("HotelDelete");
		return mv;
	}
	
	
	@RequestMapping("/DeleteHotelResult")
	public ModelAndView deleteResult(@ModelAttribute Hotel hotel) {
		
		ModelAndView modelAndView =new ModelAndView();
		try {
			if(hService.removeHotel(hotel.getHid()))
			{
				modelAndView.setViewName("deletesuccess");
			}
			else
			{
				modelAndView.setViewName("failure");
}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modelAndView;
		
	} 
	
	@RequestMapping("/ViewHotel")
	public ModelAndView display()
	{
		ModelAndView mv= new ModelAndView();
		mv.addObject("command",new Hotel());
		try {
			mv.addObject("msg",hService.viewAllHotel());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv.setViewName("HotelView");
		return mv;
	}

}



