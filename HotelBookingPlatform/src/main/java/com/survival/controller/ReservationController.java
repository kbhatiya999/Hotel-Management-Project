package com.survival.controller;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
import com.survival.service.GuestService;
import com.survival.service.GuestServiceImpl;
import com.survival.service.ReservationService;
import com.survival.service.ReservationServiceImpl;

@Controller
//@SessionAttributes("reservationPage")
public class ReservationController {
	
	@Autowired
	ReservationService reservationService;
	
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
		
	
		Reservation reservation= new Reservation();
		
		

		
		
		
		reservationGuest.setCheckindate();
		reservationGuest.setCheckoutdate();
		reservation.setCheckindate(reservationGuest.getCheckindate());
		reservation.setCheckoutdate(reservationGuest.getCheckoutdate());
		reservation.setDealtype(reservationGuest.getDealtype());
		
		reservation.setNoofrooms(reservationGuest.getNoofrooms());
		reservation.setPid(reservationGuest.getDealtype());
		reservation.setReservationID(reservationGuest.getReservationID());
		reservation.setRtypeid(reservationGuest.getRtypeid());
		reservation.setStatus("processing");
		reservation.setU_Id(1);
		reservation.setHid(1);
		reservation.setReservationID(1);
		/*System.out.println(reservationGuest.getCheckindate()+" "+
						reservationGuest.getCheckoutdate()+" "+
							reservationGuest.getDealtype()+" "+
		
		reservationGuest.getNoofrooms()+" "+
		reservationGuest.getDealtype()+" "+
		reservationGuest.getReservationID()+" "+
		reservationGuest.getRtypeid()+" "
		);
		*/
		try {
			System.out.println(reservationService.checkAvailablity(reservation));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			if(reservationService.checkAvailablity(reservation)) {
				mv.addObject("piko",reservationGuest);
				mv.setViewName("listBookingDetails");
				return mv;
			}else {
				
				mv.setViewName("notAvailable");
				return mv;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return mv;
	}
	
	@RequestMapping("/listBookingDetails")
	public ModelAndView listDetails(@ModelAttribute ReservationGuest reservationGuest, HttpServletRequest request)
	{
				
		
		ReservationService reservationservice = new ReservationServiceImpl();
		Reservation reservation= new Reservation();
		
		
		reservation.setCheckindate(reservationGuest.getCheckindate());
		reservation.setCheckoutdate(reservationGuest.getCheckoutdate());
		reservation.setDealtype(reservationGuest.getPid());
		reservation.setHid(reservationGuest.getHid());
		reservation.setNoofrooms(reservationGuest.getNoofrooms());
		reservation.setPid(reservationGuest.getPid());
		reservation.setRtypeid(reservationGuest.getRtypeid());
		reservation.setStatus("booked");
		reservation.setU_Id(1);
		reservation.setHid(1);
		
		
		Guest guest=new Guest();
		guest.setEmail(reservationGuest.getEmail());
		guest.setName(reservationGuest.getName());
		guest.setPhone(reservationGuest.getPhone());
		guest.setReservationid(reservation.getReservationID());
		
		GuestService guestservice=new GuestServiceImpl();
		
		String paymentMode = reservationGuest.getModeofpayment();
				
		ModelAndView mv = new ModelAndView();
		
		if(paymentMode.equalsIgnoreCase("02"))
		{
			try {
				reservationservice.bookHotel(reservation);
				guest.setModeofpayment("Cash");
				guestservice.enterGuest(guest);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			mv.setViewName("confirmationSuccessCash");
			
		}else if(paymentMode.equalsIgnoreCase("01"))
		{
			
			try {
				reservationservice.bookHotel(reservation);
				guest.setModeofpayment("Online");
				guestservice.enterGuest(guest);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
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
