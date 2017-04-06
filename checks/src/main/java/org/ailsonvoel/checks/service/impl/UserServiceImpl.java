package org.ailsonvoel.checks.service.impl;

import org.ailsonvoel.checks.service.api.UserService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public String authenticate() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
