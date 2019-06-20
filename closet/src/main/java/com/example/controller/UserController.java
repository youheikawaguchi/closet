package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.User;
import com.example.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
//	@ModelAttribute
//	public User setupForm() {
//		return new User();
//		}
	
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
		
		userService.createUser(user);

		return new ModelAndView ("redirect:/users/profile");
	}
	
//	@RequestMapping(value = "user", method = RequestMethod.POST)
//	String create(@Validated User form, BindingResult bindingResult) {
//		if (bindingResult.hasErrors()) {
//			return "users/createacc";
//		}
//		User user =new User();
//		user.setUserId(form.getUserId());
//		userService.create(user, form.getPassword());
//		return "redirect:/users/profile";
//	}
	
//	プロフィール作成
	@RequestMapping(value = "users/profile", method = RequestMethod.GET)
	String createFinish() {
		return "users/profile";
	}
}