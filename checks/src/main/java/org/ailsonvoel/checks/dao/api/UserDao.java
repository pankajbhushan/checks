package org.ailsonvoel.checks.dao.api;

import org.ailsonvoel.checks.domain.User;

public interface UserDao {
	User findByUserName(String username);
	User register (User user);
}
