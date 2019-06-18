package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class TopController {
	//@GetMapping( "/top") 
	//public String top() {
	//	return "top";
    //}
	@GetMapping(value= {"/top"})
	public ModelAndView item() {
	    return new ModelAndView("redirect:/top/top");
	}
	
	@GetMapping("/top/top")
	public ModelAndView showMyAccount(ModelAndView mav) {
		mav.setViewName("top/top");
		return mav;
	}
}
