package org.ailsonvoel.checks.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class AuthenticationController{

	@RequestMapping(method=RequestMethod.GET)
	public String authenticateUser(){
		return "login";		
	}
       

}
