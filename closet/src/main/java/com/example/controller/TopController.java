package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
		mav.setViewName("top/top");
		return mav;
	}
	
}
