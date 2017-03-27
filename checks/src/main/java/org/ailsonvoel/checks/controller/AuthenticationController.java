package org.ailsonvoel.checks.controller;

import org.ailsonvoel.checks.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class AuthenticationController{

	@Autowired
	AuthenticationService authenticationService;
	
	@RequestMapping(method=RequestMethod.POST)
	public String authenticateUser(){
		authenticationService.authenticate();
		return "home";		
	}
	
	
       

}
