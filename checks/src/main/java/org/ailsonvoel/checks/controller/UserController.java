package org.ailsonvoel.checks.controller;

import org.ailsonvoel.checks.domain.User;
import org.ailsonvoel.checks.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController{

	@Autowired
	UserService userService;
	
	@RequestMapping(value="/login")
	public String loginGetRedirect(){
		System.out.println("/login");
		return "login";		
	}
	
	@RequestMapping(value="/loginfailed")
	public String authenticationFailed(){
		return "login";
	}
	
	@RequestMapping("/login/register")
	public String register(@RequestParam("new_username") String userName,@RequestParam("new_password") String password
							, Model model){
		User user = userService.register(userName, password);
		if(user.getPassword().equalsIgnoreCase("user_already_exists")){
			model.addAttribute("registerMessage","Account already exists. Please login to continue.");
			System.out.println("User already exists");
			return "login";
		}else if(user.getPassword().equalsIgnoreCase("user_registered_successfully")){
			model.addAttribute("registerMessage","Account Registered Successfully");
			System.out.println("User registered successfully");
		}
		return "home";
	}
	
	@RequestMapping(value="/home")
	public String loadDashboard(){
		return "home";
	}
	
	@RequestMapping("/logout")
    public String logout(){
        return "login";
	}
    
	@RequestMapping(value={"/login/finduser","/test"})
	public String findUserByName(@RequestParam("fusername") String username, Model model){
		User user = userService.findByUserName(username);
		System.out.println("finduser called");
		if(user != null){
			model.addAttribute("result","User found");
		}else{
			model.addAttribute("result", "No user found");
		}
		return "test";
	}
	
	/*@RequestMapping(value="/login", method=RequestMethod.POST)
	public String authenticateUser(){	
		System.out.println("/login post called");
		return "redirect:/home";		
	}
	
	@RequestMapping(value="/login/{userName}",method=RequestMethod.POST)
	public String loadUser(@RequestParam String userName){		
		//and then load user details in home page
		return "redirect:/home";		
	}*/
	

}
