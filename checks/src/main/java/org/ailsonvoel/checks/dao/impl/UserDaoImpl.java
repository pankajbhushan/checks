package org.ailsonvoel.checks.dao.impl;

import java.util.List;

import org.ailsonvoel.checks.dao.api.UserDao;
import org.ailsonvoel.checks.domain.Authorities;
import org.ailsonvoel.checks.domain.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

	private SessionFactory sessionFactory;

	private SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	private void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public User findByUserName(String userName) {
		Session session = getSessionFactory().openSession();
		Query query = session.createQuery("from User where username= :userName");
		query.setString("userName", userName);
		@SuppressWarnings("unchecked")
		List<User> user = (List<User>)query.list();
		session.close();
		if(!user.isEmpty())
			return user.get(0);
		else return null;
	}

	@Override
	public User registerNewUser(User user,Authorities authorities) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		//Saving user in the users table
		//Also storing users default role as USER_ROLE in authorities		
		session.save(user);
		session.save(authorities);
		session.getTransaction().commit();
		session.close();
		return user;
	}

	@Override
	public boolean resetPassword(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatePassword(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
