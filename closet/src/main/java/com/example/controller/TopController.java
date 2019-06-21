package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Item;
import com.example.service.TopService;


@Controller
public class TopController {
	@Autowired
	TopService topService;
	
	@GetMapping("/top")
	public ModelAndView top(ModelAndView mav) {
		List<Item> items = topService.getAllItems();
		mav.addObject("items", items);
		mav.setViewName("top/top");
		return mav;
	}
	
	
	/*
	@GetMapping
	String list(Model model) {
		List<Item> items = topService.l();
		model.addAttribute("items", items);
		return "top/top";
	}
	*/
	
	
	
	/*
	@GetMapping
	public ModelAndView  list(ModelAndView mav) {
		List<Item> items = topService.findAll();
		mav.addObject("items", items);
		return mav;
	}
	*/
	
	
}
