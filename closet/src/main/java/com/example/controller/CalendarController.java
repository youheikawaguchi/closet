package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Calender;
import com.example.service.CalendarService;

@Controller
public class CalendarController {
	
	@Autowired
	CalendarService calendarService;
	
	@GetMapping({"/calender"})
	public ModelAndView showCalendar() {
		return new ModelAndView("redirect:/calender/calendar");
	}
	
	@GetMapping("/calender/calendar_test")
	public ModelAndView showCalendarTest(ModelAndView mav) {
		List<Calender> calendarlist = calendarService.getAllCalendar();
		
		mav.addObject("calendarlist", calendarlist);
		mav.setViewName("calender/calendar_test");
		return mav;
	}
}
