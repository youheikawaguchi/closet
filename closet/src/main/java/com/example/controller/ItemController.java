package com.example.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ItemController {
	
	@GetMapping(value= {"/item"})
	public ModelAndView item() {
		return new ModelAndView("redirect:/item/item_list");
	}
	
	/*
	@RequestMapping(value = "/item_edit", method = RequestMethod.GET)
	public String item_add() {
	
		return "item_edit";
	}
	
	@RequestMapping(value = "/item/item_details", method = RequestMethod.GET)
	public String item_details() {
		return "item_details";
	}
	
	@RequestMapping(value = "/item/item_list", method = RequestMethod.GET)
	public String item_list() {
		return "item_list";
	}
	*/
	
	@GetMapping("/item/item_list")
	public ModelAndView item_list(ModelAndView mav) {

		//mav.addObject("user", user);
		mav.setViewName("item/item_list");

		return mav;
	}
	
	@GetMapping("/top/top")
	public ModelAndView top(ModelAndView mav) {

		//mav.addObject("user", user);
		mav.setViewName("top/top");

		return mav;
	}
	
}