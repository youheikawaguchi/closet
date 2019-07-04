package com.example.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Calendar;
import com.example.model.CalendarForm;
import com.example.model.CoordinateForm;
import com.example.service.CalendarService;

@Controller
public class CalendarController {
	
	@Autowired
	CalendarService calendarService;
	
	// カレンダーの表示
	@GetMapping("/calendar")
	public ModelAndView showCalendar(ModelAndView mav) {
		List<Calendar> calendarlist = calendarService.getAllCalendar();
		
		mav.addObject("calendarlist", calendarlist);
		mav.setViewName("calendar/calendar");
		return mav;
	}
		
	@ResponseBody
	@GetMapping("/calendar/getcode")
	public ResponseEntity<List<Calendar>> json(){
 
		List<Calendar> calendarlist = null;
//		if(key.isPresent()) {
			//calendarlist = calendarService.getMonthCalendar(key.get());
			calendarlist = calendarService.getAllCalendar();
//		}
 
		return ResponseEntity.ok(calendarlist);
	}
	
	//あとでget→postにする
	@ResponseBody
	@GetMapping("/calendar/getdatecoorde")
	public ResponseEntity<Calendar> dateCoorde(@RequestParam("userid") int userid, @RequestParam("date") Date date){
 
		Calendar calendar = null;
		calendar = calendarService.getCalendarByDate(userid, date);
 
		return ResponseEntity.ok(calendar);
	}	
	    
	// コーデ詳細の表示
	@GetMapping({"/calendar/Clnder_code_dsc", "/calendar/details"})
	public ModelAndView showCalendarCoord(ModelAndView mav, @RequestParam(name = "c_id", required = false) String c_id) {

		mav.setViewName("calendar/Clnder_code_dsc");
//		mav.setViewName("calendar/Clnder_code_dsc" + c_id);
		return mav;
	}
	
	// カレンダー登録の表示
	@GetMapping("/calendar/add")
	public ModelAndView showAddCalendar(ModelAndView mav, @RequestParam(name = "date", required = false) String date) {

		mav.addObject("date", date);

		mav.addObject(new CoordinateForm());
		mav.addObject(new CalendarForm());
		
		mav.setViewName("/coordinate/code_add");
		return mav;
	}
	
	// カレンダー登録の登録処理
    @PostMapping(value = {"/calendar/add"})
    public ModelAndView AddCalendar(ModelAndView mav, 
    		@ModelAttribute("calendar") @Validated CalendarForm calendarForm, 
    		@AuthenticationPrincipal UserDetails userDetails,
    		BindingResult bindingResult){
    	
    	calendarService.createCalendar(calendarForm, userDetails);
        mav.setViewName("/calendar");
        
        return mav;
    }
}
