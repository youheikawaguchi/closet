package com.example.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ItemController {
	
	@GetMapping(value= {"/item"})
	public ModelAndView item() {
		return new ModelAndView("redirect:/item/item_list");
	}
/*	
	//アイテム登録
	@GetMapping("/item/select")
	public ModelAndView item_select(ModelAndView mav) {

		mav.setViewName("item/select");

		return mav;
	}
	
	//アイテム一覧
	@GetMapping("/item/item_list")
	public ModelAndView item_list(ModelAndView mav) {

		//mav.addObject("user", user);
		mav.setViewName("item/item_list");

		return mav;
	}
	
	//アイテム詳細
	@GetMapping("/item/item_details")
	public ModelAndView item_details(ModelAndView mav) {

		mav.setViewName("item/item_details");

		return mav;
	}
	
	//アイテム編集
	@GetMapping("/item/item_edit")
	public ModelAndView item_edit(ModelAndView mav) {

		mav.setViewName("item/item_edit");

		return mav;
	}
*/
	
	@RequestMapping("/item/item_edit")
	String login(){
	    return "login/item_edit";
	    }
	

	
}