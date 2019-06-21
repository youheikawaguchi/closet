package com.example.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Item;
import com.example.service.TopService;


@Controller
public class TopController {
	
	@Autowired
	TopService topService;
	
	
	public static int[] getSeason() {
		LocalDate date = LocalDate.now();
		int month = date.getMonthValue();
//		List<Integer> month_list1 = new ArrayList<>();
//		month_list1.add(4);
//		month_list1.add(6);
//		List<Integer> month_list2 = new ArrayList<>();
//		month_list2.add(4);
//		month_list2.add(6);
//		List<Integer> month_list3 = new ArrayList<>();
//		month_list3.add(1);
//		month_list3.add(6);
//		List<Integer> month_list4 = new ArrayList<>();
//		month_list4.add(1);
//		month_list4.add(6);
//		List<Integer> month_list5 = new ArrayList<>();
//		month_list5.add(1);
//		month_list5.add(5);
//		List<Integer> month_list6 = new ArrayList<>();
//		month_list6.add(2);
//		month_list6.add(5);
//		List<Integer> month_list7 = new ArrayList<>();
//		month_list7.add(2); //7
//		month_list7.add(5);
//		List<Integer> month_list8 = new ArrayList<>();
//		month_list8.add(2); //8
//		month_list8.add(5);
//		List<Integer> month_list9 = new ArrayList<>();
//		month_list9.add(3); //9
//		month_list9.add(6); //9
//		List<Integer> month_list10 = new ArrayList<>();
//		month_list10.add(3); //10
//		month_list10.add(6); //10
//		List<Integer> month_list11 = new ArrayList<>();
//		month_list11.add(4); //11
//		month_list11.add(6); //11
//		List<Integer> month_list12 = new ArrayList<>();
//		month_list12.add(4); //12
//		month_list12.add(6); //12
//		
//		Map<Integer, List<Integer>> season_map = new HashMap<>();
//		season_map.set(1, (2,5));
//		
		int seasonId[] = new int[2];
		
		if(month >= 3 && month <= 5) {
			seasonId[0] = 1;
		}else if(month >= 6 && month <= 8) {
			seasonId[0] = 2;
		}else if(month >= 9 && month <= 10) {
			seasonId[0] = 3;
		}else if(month >= 11 && month <= 12 || month <= 2 ) {
			seasonId[0] = 4;
		}
		
		if(month >=5 && month <= 8) {
			seasonId[1] = 5;
		}else if(month >= 9 && month <= 12 || month <= 4) {
			seasonId[1] = 6;
		}
	
		return seasonId;
		
	}
	

	@GetMapping("/top")
	public ModelAndView top(ModelAndView mav) {	
		List<Item> items = topService.getSlideItems();
		mav.addObject("items", items);
		mav.setViewName("top/top");
		return mav;
	}
	/*
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView slideSeason(ModelAndView mav, @RequestParam("seasonId") int seasonId) {
		LocalDate date = LocalDate.now();
		int month = date.getMonthValue();
		switch(month) {
		case 3:
		case 4:
		case 5:
			seasonId = 1;
			break;
		case 6:
		case 7:
		case 8:
			seasonId = 2;
			break;
		}
		mav.addObject("seasonId",seasonId);
		return mav;
	}
	*/
	
	
}
