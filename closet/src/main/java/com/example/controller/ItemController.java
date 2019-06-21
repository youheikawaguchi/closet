package com.example.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Category;
import com.example.model.Color;
import com.example.model.Item;
import com.example.model.Season;
import com.example.model.SubCategory;
import com.example.service.ItemService;


@Controller
public class ItemController {

	@Autowired
	ItemService itemservice;
	
	@GetMapping(value= {"/item"})
	public ModelAndView item() {
		return new ModelAndView("redirect:/item/item_list");
	}

	//アイテム登録/編集
	@GetMapping("/item/item_edit")
	public ModelAndView ItemEdit(ModelAndView mav) {
		
		
		
		mav.setViewName("item/item_edit");

		return mav;
	}
	
	
	@PostMapping("/item/item_edit")
	public ModelAndView postItemEdit(@ModelAttribute("item") @Validated Item item) { 
		/*
		Category category = getCategoryById(categoryId);
		SubCategory subcategory = getSubCategoryById(subcategoryId);
		Season season = getSeasonById(seasonId);
		Color color = getColorById(colorId);
		
		itemservice.ItemCreate(item, category, subcategory, season, color);
		*/
		return new ModelAndView("redirect:/item/item_details");
	}
	
	
	//ここでITEMとカテゴリと季節の型を作る
	
	
	
	
	//アイテム一覧
	@GetMapping("/item/item_list")
	public ModelAndView ItemList(ModelAndView mav) {
		//mav.addObject("user", user);
		mav.setViewName("item/item_list");

		return mav;
	}
	
	//アイテム詳細
	@GetMapping("/item/item_details")
	public ModelAndView ItemDetails(ModelAndView mav) {

		mav.setViewName("item/item_details");

		return mav;
	}
	
	//アイテムselect
	//アイテム詳細
	@GetMapping("/item/item_select")
	public ModelAndView ItemSelect(ModelAndView mav) {

		mav.setViewName("item/item_select");

		return mav;
	}
	
	
	
}