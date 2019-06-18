package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class itemController {
	
	@GetMapping(value= {"/item"})
	public ModelAndView item() {
		return new ModelAndView("redirect:/item/item_list");
	}

	@GetMapping(value = { "/item/item_list" })
	
	
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
	
	
}