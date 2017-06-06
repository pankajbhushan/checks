package org.ailsonvoel.checks.service.api;

import org.ailsonvoel.checks.domain.User;

public interface UserService {
	User findByUserName(String username);
	User register(String username, String password);
}
