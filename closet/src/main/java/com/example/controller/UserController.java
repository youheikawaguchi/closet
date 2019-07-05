package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Area;
import com.example.model.ErrorData;
import com.example.model.User;
import com.example.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;

	
//	ユーザー登録
	@GetMapping("/createacc")
	ModelAndView userForm(ModelAndView mav) {
		
		User user =new User();
		mav.addObject(user);
		
		String title = "はじめまして！";
		mav.addObject("title",title);
		
		mav.setViewName("users/createacc");
		return mav;
	}
	
	
	//コントローラにPOSTされた時の処理
	@PostMapping("/createacc")
	public ModelAndView addUser(@ModelAttribute("user") @Validated User user, 
			BindingResult bindingResult,
			ModelAndView mav) {
		
		if(userService.createUser(user)) {
			List<Area> areaList = userService.getAllArea();
			mav.addObject("areaList", areaList);
			mav.setViewName("login/login");
			return mav;
		}else {
			ErrorData errorMsg = new ErrorData();
			mav.setViewName("users/createacc");
			mav.addObject("errorMsg", errorMsg.getAddUser());
			return mav;
		}
	}

//	プロフィールへ遷移
//	@RequestMapping(value = "users/profile", method = RequestMethod.GET)
//	String createFinish() {
//		return "users/profile";
//	}
	
	@GetMapping("/profile")
	ModelAndView userProfiel(ModelAndView mav,
			@AuthenticationPrincipal UserDetails userDetails) {
	
		User user = userService.getUserByUserId(userDetails.getUsername());
		mav.addObject("user",user);
		
		List<Area> areaList = userService.getAllArea();
		mav.addObject("areaList", areaList);
		
		mav.setViewName("users/profile");
		return mav;
	}

//	プロフィール登録処理
	@PostMapping("/profile")
	public ModelAndView addprofile(@ModelAttribute("user") @Validated User user, 
			BindingResult bindingResult,
			ModelAndView mav, @AuthenticationPrincipal UserDetails userDetails) {
		//if(bindingResult.hasErrors()) {
			//バインドエラー時
		//}
		User viewer = userService.getUserByUserId(userDetails.getUsername());
		
		 userService.createProfile(user, viewer);

		return new ModelAndView ("redirect:/top");
	}
}