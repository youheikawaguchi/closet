package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.User;
import com.example.service.UserService;

@ControllerAdvice(assignableTypes = {CalendarController.class, CoordinateController.class, ItemController.class, TopController.class})
public class HeaderController {
	@Autowired
	UserService userService;
	
	@ModelAttribute 
    public void authenticate(ModelAndView mav, @AuthenticationPrincipal UserDetails userDetails) {
		User user = userService.getUserByUserId(userDetails.getUsername());
		mav.addObject("user",user);
    }
}
