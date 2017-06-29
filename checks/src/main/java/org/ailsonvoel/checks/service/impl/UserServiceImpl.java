package org.ailsonvoel.checks.service.impl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

import org.ailsonvoel.checks.dao.api.UserDao;
import org.ailsonvoel.checks.domain.Authorities;
import org.ailsonvoel.checks.domain.User;
import org.ailsonvoel.checks.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao dao;

	@Override
	public boolean registerNewUser(String username, String password) {
		boolean result = false;
		User user = dao.findByUserName(username);
		if(user == null){
			user = new User();
			user.setUsername(username);
			user.setPassword(password);
			//TODO Enabled should be set to false until user verifies the email confirmation link
			user.setEnabled(true);
			Authorities authorities =  new Authorities();
			authorities.setUserName(user.getUsername());
			authorities.setRole("ROLE_USER");
			//Dao returns back user in case any future logic is to be proccessed
			dao.registerNewUser(user,authorities);
			result = true;
		}
		return result;
	}

	@Override
	public User findByUserName(String username) {
		User user = dao.findByUserName(username);
		return user;
	}

	
	//TODO make the method scope as private
	@Override
	public String generateResetPasswordToken(String username) {
		String message = null;
		User user = dao.findByUserName(username);
		if(user==null){
			message = "Please check the email id entered.";
		}else{
			message = UUID.randomUUID().toString();
		}
		return message;
	}

	/**
	 *@description Check against database 
	 */
	@Override
	public boolean resetPassword(String username) {
		String tempPassword = generateResetPasswordToken(username);
		String fromAddress = "1pankaj4@gmail.com";
		String toAddress = "pkbytube@gmail.com"; //TODO Username should come in production env
		String subject = "Password Reset Request";
		try {
			URL resetUrl = new URL("http://localhost:8080/checks/passwordreset?username="+username+"&token="+tempPassword);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} // TODO change in production environment and add to spring security
		String body = "Please click on the below link to reset your password."
				+ "";
		return false;
	}

	@Override
	public boolean updatePassword(User user) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
