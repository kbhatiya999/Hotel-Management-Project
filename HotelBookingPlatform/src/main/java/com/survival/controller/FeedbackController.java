package com.survival.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.survival.entities.Feedback;
import com.survival.persistence.FeedbackDao;
import com.survival.service.FeedbackService;



@Controller
public class FeedbackController {
	
	private int rating;
	private String str;
	int hidTemp = 123;
	@Autowired
	 FeedbackService fbd;
	
	@RequestMapping("/")
	public ModelAndView first(){
		ModelAndView mv=new ModelAndView();
		mv.addObject("hid", hidTemp);
		mv.setViewName("feedback");
		return mv;
	}
	
	@RequestMapping("/cal1")
	public ModelAndView second (@RequestParam("tb1") String b1, @RequestParam("tb2") String b2)
			{
		ModelAndView mv=new ModelAndView();
		
		rating=Integer.parseInt(b1);
		if(rating<3 && b2.isEmpty()) {
			mv.setViewName("bye");
		}
		else {
			str=b2;
			boolean fl=false,fl1=false;
			Feedback fb = new Feedback(2,2,rating,str);
			try {
				fl=fbd.insertFeedback(fb);
				fl1=fbd.updateHotelRating(rating, 2);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(fl && fl1)mv.addObject("asdf", str);
			else mv.addObject("asdf", "Not Done");
			mv.setViewName("byebye");
		}
		
		mv.addObject("hid", hid);
		return mv;
	}
	
	@RequestMapping("/cal")
	public ModelAndView third (@RequestParam("tb1") String b1 ){
		ModelAndView mv=new ModelAndView();
		str=b1;
		
		mv.setViewName("byebye");
		boolean fl=false,fl1=false;
		Feedback fb = new Feedback(2,2,rating,str);
		try {
			fl=fbd.insertFeedback(fb);
			fl1=fbd.updateHotelRating(rating, 2);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(fl && fl1)mv.addObject("asdf", str);
		else mv.addObject("asdf", "Not Done");
		return mv;
	}
	
	

}
