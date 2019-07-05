package com.example.controller;

import com.example.model.Item;
import com.example.model.ItemForm;
import com.example.model.ItemSelect;
import com.example.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
//import org.springframework.mock.web.MockMultipartFile;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

	//アイテム登録
	@GetMapping("/item/item_edit")
	public ModelAndView ItemEdit(ModelAndView mav) {

		ItemSelect itemSelect = itemservice.itemCreateForm();
		mav.addObject("itemForm", new ItemForm());
		mav.addObject("itemSelect", itemSelect);
		
		mav.setViewName("item/item_edit");

		return mav;
	}
	
	//アイテム編集
	@GetMapping("/item/item_edit{id}")
	public ModelAndView ItemCompilation(ModelAndView mav, @PathVariable("id") String id,@AuthenticationPrincipal UserDetails userDetails) {
		ItemSelect itemSelect = itemservice.itemCreateForm();
		ItemForm EditItemForm = new ItemForm();
		Item item = itemservice.getItemById(Integer.parseInt(id));
		EditItemForm.setCategoryId(item.getCategory().getCategoryId());
		EditItemForm.setSubCategoryId(item.getSubCategory().getSubCategoryId());
		EditItemForm.setSeasonId(item.getSeason().getSeason_id());
		EditItemForm.setColorId(item.getColor().getColorId());
		EditItemForm.setMemo(item.getComment());
		EditItemForm.setItemId(item.getItemId());

		List<Item> itemList = itemservice.userItemList(userDetails);
		
		mav.addObject("itemForm",EditItemForm);
		mav.addObject("itemSelect", itemSelect);
		mav.addObject("itemList", itemList);
		mav.setViewName("item/item_edit");
		return mav;
		}
	
	@PostMapping("/item/item_edit")
	public ModelAndView postItemEdit(@ModelAttribute ItemForm itemForm, ModelAndView mav, @AuthenticationPrincipal UserDetails userDetails) {
		Item i;
		if (itemForm.getPicture().isEmpty()) {
			mav.setViewName("redirect:/item/item_edit");
			return mav;
		}
		if(itemForm.getItemId() == null) {
			i = itemservice.ItemCreate(itemForm, userDetails);
		}else {
			i = itemservice.itemUpdate(itemForm.getItemId(), itemForm, userDetails);
		}
		
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
	
    //アイテム削除
	@DeleteMapping("/item/item_details{id}")
    public ModelAndView destroy(ModelAndView mav, @PathVariable("id") String id) {
        itemservice.delete(Integer.parseInt(id));
        mav.setViewName("redirect:/item/item_list");
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