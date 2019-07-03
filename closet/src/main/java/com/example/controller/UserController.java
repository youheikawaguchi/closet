package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.User;
import com.example.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
//	ユーザー登録
	@GetMapping(value="users/createacc")
	ModelAndView userForm(ModelAndView mav) {
	
		User user =new User();
		mav.addObject(user);
		
		mav.setViewName("users/createacc");
		return mav;
	}
	//コントローラにPOSTされた時の処理
	@PostMapping(value = "/users/createacc")
	public ModelAndView addUser(@ModelAttribute("user") @Validated User user, 
			BindingResult bindingResult,
			ModelAndView mav) {
		
		if(userService.createUser(user)) {
			mav.setViewName("/users/profile");
			return mav;
		}else {
			mav.setViewName("/users/createacc");
			return mav;
		}
	}

//	プロフィールへ遷移
//	@RequestMapping(value = "users/profile", method = RequestMethod.GET)
//	String createFinish() {
//		return "users/profile";
//	}
	
	@GetMapping(value="users/profile")
	ModelAndView userProfiel(ModelAndView mav,
			@AuthenticationPrincipal UserDetails userDetails) {
	
		User user = userService.getUserByUserId(userDetails.getUsername());
		mav.addObject("user",user);
		
//		User user =new User();
//		mav.addObject(user);
		
		mav.setViewName("users/profile");
		return mav;
	}

//	プロフィール登録処理
	@PostMapping(value = "/users/profile")
	public ModelAndView addprofiel(@ModelAttribute("user") @Validated User user, 
			BindingResult bindingResult,
			ModelAndView mav, @AuthenticationPrincipal UserDetails userDetails) {

		User viewer = userService.getUserByUserId(userDetails.getUsername());
		
		 userService.createProfile(user, viewer);

		return new ModelAndView ("redirect:/top");
	}
}