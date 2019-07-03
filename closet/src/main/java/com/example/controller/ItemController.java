package com.example.controller;

import com.example.model.Item;
import com.example.model.ItemForm;
import com.example.model.ItemSelect;
import com.example.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


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
	
	//アイテム登録/編集
		@GetMapping("/item/item_edit{id}")
		public ModelAndView ItemCompilation(ModelAndView mav, @PathVariable("id") String id) {
			System.out.println(id);
			
			ItemSelect itemSelect = itemservice.itemCreateForm();
			ItemForm EditItemForm = new ItemForm();
			Item item = itemservice.getItemById(Integer.parseInt(id));
			EditItemForm.setCategoryId(item.getCategory().getCategoryId());
			EditItemForm.setSubCategoryId(item.getSubCategory().getSubCategoryId());
			EditItemForm.setSeasonId(item.getSeason().getSeason_id());
			EditItemForm.setColorId(item.getColor().getColorId());
			EditItemForm.setMemo(item.getComment());
			System.out.println(EditItemForm);
			mav.addObject("itemForm",EditItemForm);
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
		Item i = itemservice.ItemCreate(itemForm, userDetails);
		return new ModelAndView("redirect:/item/item_details" + i.getItemId().toString());
	}	
	
	//アイテム一覧
	@GetMapping("/item/item_list")
	public ModelAndView ItemList(ModelAndView mav, @AuthenticationPrincipal UserDetails userDetails) {
		//mav.addObject("user", user);
		ItemSelect itemSelect = itemservice.itemCreateForm();
		List<Item> itemList = itemservice.userItemList(userDetails);

		mav.addObject("itemSelect", itemSelect);
		mav.addObject("itemList", itemList);
		mav.setViewName("item/item_list");

		return mav;
	}
	
	//アイテム詳細
	@GetMapping("/item/item_details{id}")
	public ModelAndView ItemDetails(ModelAndView mav, @PathVariable("id") String id) {
		Item item = itemservice.getItemById(Integer.parseInt(id));
		mav.addObject("item",item);
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