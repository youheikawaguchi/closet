package com.example.controller;

import com.example.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("targetId")
public class LoginController {

	@ModelAttribute("targetId")
	public Integer setUpdTargetId() {
		return -1;
	}

	@GetMapping("/login")
    public ModelAndView login(){
	    ModelAndView mav = new ModelAndView();
	    mav.setViewName("login/login");
	    return mav;
    }
}