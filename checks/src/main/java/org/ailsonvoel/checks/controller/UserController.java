package org.ailsonvoel.checks.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.ailsonvoel.checks.domain.User;
import org.ailsonvoel.checks.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController{

	@Autowired
	UserService userService;
	
	@RequestMapping(value="/login")
	public void loginSuccess(HttpServletRequest request, Model model){
		if(request.getParameter("error")!=null){
			String error = request.getParameter("error");
			model.addAttribute("error",error);
		}else if(request.getParameter("logout")!=null){
			request.getSession().invalidate();
			String logout = request.getParameter("logout");
			model.addAttribute("logout",logout);
		}	
	}
	
	@RequestMapping(value = "/login/register", method=RequestMethod.POST)
	public String register(@RequestParam("new_username") String userName,@RequestParam("new_password") String password
							, Model model){
		
		if(!userService.registerNewUser(userName, password)){
			//Check if the account already exists. If yes then inform the same to user else
			//display message that registration failed.
			User user = userService.findByUserName(userName);
			if(user!= null){
				model.addAttribute("registerMessage","Account already exists. Please login to continue.");
			}else{
				model.addAttribute("registerMessage","That's Weird! Registration has failed. Please try again.");
			}
			return "login";
		}else{
			model.addAttribute("username",userName);
			return "home";
		}
	}
	
	@RequestMapping(value="/home")
	public String loadDashboard(Principal principal, Model model){
		model.addAttribute("username", principal.getName());
		return "home";
	}
	
    
	@RequestMapping(value={"/login/finduser","/test"})
	public String findUserByName(@RequestParam("fusername") String username, Model model){
		User user = userService.findByUserName(username);
		if(user != null){
			model.addAttribute("result","User found");
		}else{
			model.addAttribute("result", "No user found");
		}
		return "test";
	}
	

}
