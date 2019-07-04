package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Area;
import com.example.model.Item;
import com.example.model.User;
import com.example.service.TopService;
import com.example.service.UserService;


@RestController
public class TopController {
	
	@Autowired
	TopService topService;
	
	@GetMapping("/top")
	public ModelAndView top(ModelAndView mav, @AuthenticationPrincipal UserDetails userDetails) {	
		List<Item> items = topService.getSlideItems(userDetails);
		mav.addObject("items", items);
		Area area = topService.getArea(userDetails);
		mav.addObject("area", area);
		mav.setViewName("top/top");
		return mav;
	}
	
}
