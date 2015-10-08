package org.aacish.disease_prediction.controller;

import javax.servlet.http.HttpSession;

import org.aacish.disease_prediction.model.AdminBean;
import org.aacish.disease_prediction.model.Authenticator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class UserController {

	@RequestMapping(value="/login", method=RequestMethod.POST)
	
	public String login(@ModelAttribute("user")AdminBean admin,HttpSession session, ModelMap model){
		
		
		if(new Authenticator().authenticate(admin)){
			session.setAttribute("user", admin);
			model.addAttribute("message", "Login Successful");
		}
		else{
			model.addAttribute("message", "Login Error!!");
		}
		return "status";
		
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	
	public String logout(HttpSession session){
		session.setAttribute("user", null);
		
		return "redirect:home";
	}
}
