package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Area;
import com.example.model.Item;
import com.example.service.TopService;


@RestController
public class TopController {
	
	@Autowired
	TopService topService;
	
	@GetMapping("/top")
	public ModelAndView top(ModelAndView mav) {	
		List<Item> items = topService.getSlideItems();
		mav.addObject("items", items);
		List<Area> area = topService.getArea();
		mav.addObject("area", area);
		mav.setViewName("top/top");
		return mav;
	}
	
	/*
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView showHomePage() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser user = (LoginUser) authentication.getPrincipal();
        return new ModelAndView("index", "userProfile", user.getUserProfile());
    }
	*/
}
