package org.ailsonvoel.checks.test.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import org.ailsonvoel.checks.dao.api.UserDao;
import org.ailsonvoel.checks.domain.Authorities;
import org.ailsonvoel.checks.domain.User;
import org.ailsonvoel.checks.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * @author Alice
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
	
	@InjectMocks
	private UserServiceImpl userServiceImpl = new UserServiceImpl();
	
	@Mock
	private UserDao userDaoImpl;
	
	private User user = new User();
	private Authorities authorities = new Authorities();
	
	@Before
	public void setUp(){
		user.setUsername("pankaj");
		user.setPassword("TestPassword");
		authorities.setUserName("pankaj");
		authorities.setRole("ROLE_USER");
	}
	
	@Test
	@Ignore
	public void testRegister() {
		when(userDaoImpl.registerNewUser(user,authorities)).thenReturn(user);
		when(userDaoImpl.findByUserName("pankaj")).thenReturn(null);
		assertTrue(userServiceImpl.registerNewUser("pankaj", "TestPassword"));
		fail("Not yet implemented");
	}
	
	@Test
	public void testForGeneratingTemporaryPasswordWhenUserExists(){
		when(userDaoImpl.findByUserName("pankaj")).thenReturn(user);
		assertNotNull(userServiceImpl.generateResetPasswordToken("pankaj"));
	}
	
	@Test
	public void testForGeneratingTemporaryPasswordWhenUserNotExists(){
		when(userDaoImpl.findByUserName("pankaj")).thenReturn(null);
		assertEquals("Please check the email id entered.",userServiceImpl.generateResetPasswordToken("pankaj"));
	}

}
