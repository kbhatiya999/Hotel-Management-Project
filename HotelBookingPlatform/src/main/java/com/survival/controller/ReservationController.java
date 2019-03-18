package com.survival.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.survival.entities.Guest;
import com.survival.entities.Reservation;
import com.survival.mixedEntities.ReservationGuest;

@Controller
@SessionAttributes("reservationPage")
public class ReservationController {
	
	ReservationGuest reservationGuest1 = new ReservationGuest();
	
	@RequestMapping("/")
	public ModelAndView first()
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("command", new ReservationGuest());
		mv.setViewName("reservation");
		return mv;
	}
	
	@RequestMapping("/reservation")
	public ModelAndView reservation(@ModelAttribute ReservationGuest reservationGuest)
	{
		ModelAndView mv = new ModelAndView();
		reservationGuest1.setModeofpayment(reservationGuest.getModeofpayment());
		mv.addObject("command",reservationGuest);
		mv.setViewName("listBookingDetails");
		return mv;
	}
	
	@RequestMapping("/listBookingDetails")
	public ModelAndView listDetails(@ModelAttribute ReservationGuest reservationGuest, HttpServletRequest request)
	{
				
		String paymentMode = reservationGuest1.getModeofpayment();
				
		ModelAndView mv = new ModelAndView();
		
		if(paymentMode.equalsIgnoreCase("02"))
		{
			mv.setViewName("confirmationSuccessCash");
			
		}else if(paymentMode.equalsIgnoreCase("01"))
		{
			mv.setViewName("confirmationSuccessOnline");
		}
		else
		{
			mv.setViewName("confirmationFailure");
		}
		
		return mv;
	}
	
	@RequestMapping("/back")
	public ModelAndView goBack()
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("command", new ReservationGuest());
		mv.setViewName("reservation");
		return mv;
	}
}
