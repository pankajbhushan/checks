package org.ailsonvoel.checks.service.impl;

import org.ailsonvoel.checks.dao.api.UserDao;
import org.ailsonvoel.checks.domain.User;
import org.ailsonvoel.checks.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao dao;

	@Override
	public User register(String username, String password) {
		User user = dao.findByUserName(username);
		if(user != null){
			//user already exists. Send information to client.
			//Sending user object to controller
			user.setPassword("user_already_exists");
		}else{
			user = new User();
			user.setUsername(username);
			user.setPassword(password);
			user.setEnabled(true);
			user = dao.register(user);
			
			// The password string is changed intentionally to accomodate for success or faliure
			//Also the password field is not required to send back to controller after account creation.
			user.setPassword("user_registered_successfully"); 
		}
		return user;
	}

	@Override
	public User findByUserName(String username) {
		User user = dao.findByUserName(username);
		return user;
	}
	
	/*

	@Override
	public String authenticate() {
		// TODO Auto-generated method stub
		return null;
	}*/
	
	
}
