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
		System.out.println("/login called for loginGetRedirect");
		return "login";		
	}
	
//	@RequestMapping(value="/login", method=RequestMethod.POST)
//	public String authenticateUser(){	
//		System.out.println("/login post called");
//		return "redirect:/home";		
//	}
//	
//	@RequestMapping(value="/login/{userName}",method=RequestMethod.POST)
//	public String loadUser(@RequestParam String userName){		
//		//TODO -- need to find user once successfully authenticated
//		//and then load user details in home page
//		return "redirect:/home";		
//	}
	
	@RequestMapping(value="/loginfailed")
	public String authenticationFailed(){
		//Add the failure messages to the view page
		System.out.println("/loginfailed called for authentication failed.");
		return "login";
	}
	
	@RequestMapping(value="/home")
	public String loadDashboard(){
		System.out.println("/home called for loading dashboard");
		return "home";
	}
	
	@RequestMapping("/logout")
    public String logout(){
        return "login";
    }
       

}
