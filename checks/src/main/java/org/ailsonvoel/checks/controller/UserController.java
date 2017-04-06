package org.ailsonvoel.checks.controller;

import org.ailsonvoel.checks.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController{

	@Autowired
	UserService userService;
	
	@RequestMapping(value="/login")
	public String loginGetRedirect(){
		return "login";		
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String authenticateUser(){	
		return "redirect:/home";		
	}
	
	@RequestMapping(value="/login/{userName}",method=RequestMethod.POST)
	public String loadUser(@RequestParam String userName){		
		//TODO -- need to find user once successfully authenticated
		//and then load user details in home page
		return "redirect:/home";		
	}
	
	@RequestMapping(value="/loginfailed")
	public String authenticationFailed(){
		//Add the failure messages to the view page
		return "login";
	}
	
	@RequestMapping(value="/home")
	public String loadDashboard(){
		return "home";
	}
	

       

}
