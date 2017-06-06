package org.ailsonvoel.checks.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="")
public class AuthenticationController {
	
	
	public String delegateToSpring(){
		return "redirect:j_spring_security_check";
	} 
	
		
}
