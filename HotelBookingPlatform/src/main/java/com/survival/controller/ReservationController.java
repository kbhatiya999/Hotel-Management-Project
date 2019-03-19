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
	
	ReservationGuest reservationGuestNew = new ReservationGuest();
	
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
		reservation.setReservationID(3);
		
		
		
		
		reservationGuestNew.copyCheckInDate(reservation.getCheckindate());
		reservationGuestNew.copyCheckOutDate(reservation.getCheckoutdate());
		reservationGuestNew.setDealtype(reservationGuest.getDealtype());
		reservationGuestNew.setEmail(reservationGuest.getEmail());
		reservationGuestNew.setGid(4);
		reservationGuestNew.setHid(1);
		reservationGuestNew.setIs_active(reservationGuest.getIs_active());
		reservationGuestNew.setName(reservationGuest.getName());
		reservationGuestNew.setNoofrooms(reservationGuest.getNoofrooms());
		reservationGuestNew.setPhone(reservationGuest.getPhone());
		reservationGuestNew.setPid(1);
		reservationGuestNew.setReservationID(3);
		reservationGuestNew.setRtypeid(reservationGuest.getRtypeid());
		reservationGuestNew.setStatus("bookede");
		reservationGuestNew.setU_Id(1);
		reservationGuestNew.setModeofpayment(reservationGuest.getModeofpayment());
		
		

		
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
				mv.addObject("command",reservationGuest);
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
		
	
		reservation.setCheckindate(reservationGuestNew.getCheckindate());
		reservation.setCheckoutdate(reservationGuestNew.getCheckoutdate());
		reservation.setDealtype(reservationGuestNew.getRtypeid());
		
		reservation.setNoofrooms(reservationGuestNew.getNoofrooms());
		reservation.setPid(reservationGuestNew.getPid());
		reservation.setRtypeid(1);
		reservation.setStatus("booked");
		reservation.setU_Id(1);
		reservation.setHid(1);
		reservation.setReservationID(3);
		
		System.out.println(reservation.getStatus()+" "+
							reservation.getDealtype()+" "+
							reservation.getHid()+" "+
							reservation.getNoofrooms()+" "+
							reservation.getPid()+" "+
							reservation.getReservationID()+" "+
							reservation.getRtypeid()+" "+
							reservation.getU_Id()+" "+
							reservation.getCheckindate()+" "+
							reservation.getCheckoutdate());
							
							
		
		
		Guest guest=new Guest();
		guest.setEmail(reservationGuestNew.getEmail());
		guest.setName(reservationGuestNew.getName());
		guest.setPhone(reservationGuestNew.getPhone());
		guest.setReservationid(reservation.getReservationID());
		guest.setGid(3);
		GuestService guestservice=new GuestServiceImpl();
		String paymentMode="";
		paymentMode = reservationGuestNew.getModeofpayment();
				System.out.println(paymentMode);
		ModelAndView mv = new ModelAndView();
		
		if(paymentMode.equalsIgnoreCase("02"))
		{
			try {
				System.out.println(reservationservice.bookHotel(reservation));
				guest.setModeofpayment("Cash");
				
				guest.toString();
				System.out.println(guestservice.enterGuest(guest));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			mv.setViewName("confirmationSuccessCash");
			
		}else if(paymentMode.equalsIgnoreCase("01"))
		{
			
			try {
				System.out.println(reservationservice.bookHotel(reservation));
				guest.setModeofpayment("Online");
				guest.toString();
				System.out.println(guestservice.enterGuest(guest));
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
