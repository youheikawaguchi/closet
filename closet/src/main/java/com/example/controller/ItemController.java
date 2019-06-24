package com.example.controller;
import com.example.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.service.CategoryService;
import com.example.service.ColorService;
import com.example.service.ItemService;
import com.example.service.SeasonService;
import com.example.service.SubCategoryService;


@Controller
public class ItemController {

	@Autowired
	ItemService itemservice;
	@Autowired
	CategoryService categoryservice;
	@Autowired
	SubCategoryService subcategoryservice;
	@Autowired
	SeasonService seasonservice;
	@Autowired
	ColorService colorservice;
	
	@GetMapping(value= {"/item"})
	public ModelAndView item() {
		return new ModelAndView("redirect:/item/item_list");
	}

	//アイテム登録/編集
	@GetMapping("/item/item_edit")
	public ModelAndView ItemEdit(ModelAndView mav) {

		ItemSelect itemSelect = itemservice.itemCreateForm();
		mav.addObject("itemForm", new ItemForm());
		mav.addObject("itemSelect", itemSelect);
		
		mav.setViewName("item/item_edit");

		return mav;
	}
	
	@PostMapping("/item/item_edit")
	public ModelAndView postItemEdit(@ModelAttribute ItemForm itemForm, ModelAndView mav, @AuthenticationPrincipal UserDetails userDetails) {
		
		//String c_name = item.getCategory().getCategoryName();
//		Category category = categoryservice.getCategoryByName(item.getCategory().getCategoryName());
//		SubCategory subcategory = subcategoryservice.getSubCategoryByName(item.getSubCategory().getSubCategoryName());
//		Season season = seasonservice.getSeasonByName(item.getSeason().getSeasonName());
//		Color color = colorservice.getColorByName(item.getColor().getColorName());
//		itemservice.ItemCreate(item, category, subcategory, season, color);

		if (itemForm.getPicture().isEmpty()) {
			mav.setViewName("redirect:/item/item_edit");
			return mav;
		}
		itemservice.ItemCreate(itemForm, userDetails);
		
		return new ModelAndView("redirect:/item/item_details");
	}	
	
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