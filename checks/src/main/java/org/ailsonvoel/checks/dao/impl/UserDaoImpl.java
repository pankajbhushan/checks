package org.ailsonvoel.checks.dao.impl;

import org.ailsonvoel.checks.dao.api.UserDao;
import org.ailsonvoel.checks.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDaoImpl implements UserDao {

	private SessionFactory sessionFactory;
	
	private Session session;

	private SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	private void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public User findByUserName(String username) {
		Session session = getSessionFactory().openSession();
		User user = (User) session.createQuery("from User where username=?")
				.setParameter(0, username);
		getSessionFactory().getCurrentSession().close();
		return user;
	}

	@Override
	@Transactional
	public User register(User user) {
		session = getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		return user;
	}

}
