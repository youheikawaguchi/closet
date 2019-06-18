package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class TopController {
	@GetMapping("/top")
	public ModelAndView item_list(ModelAndView mav) {
		mav.setViewName("top/top");
		return mav;
	}
}
