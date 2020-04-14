package org.onlineSolutions.FunnyTrip;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.onlineSolutions.FunnyTrip.config.security.AuthRequestBody;
import org.onlineSolutions.FunnyTrip.config.security.JwtTokenProvider;
import org.onlineSolutions.FunnyTrip.model.user.User;
import org.onlineSolutions.FunnyTrip.repository.UserRepository;
import org.onlineSolutions.FunnyTrip.service.loginService.LoginService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(value = SpringJUnit4ClassRunner.class)
public class LoginServiceTest {

	@Mock
	private UserRepository userRepository;

	@Mock
	private AuthenticationManager authenticationManager;

	@Mock
	private JwtTokenProvider jwtTokenProvider;

	@InjectMocks
	private LoginService loginService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void loginServiceTest() {

		User user = new User(1, "giovi", "pass123", "Giovanni", "DeMichele", "giovidemicheli@posta.it", true, "USER");
		AuthRequestBody authRequestBody = new AuthRequestBody(user.getUserName(), user.getPassword());
		Map<Object, Object> response = new HashMap<>();
		Map<Object, Object> assertion = new HashMap<>();
		
		assertion.put("username", "giovi");
		assertion.put("token", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJsdWNoaW5vIiwicm9sZXMiOlsiVVNFUiJdLCJpYXQiOjE1ODY4ODE2OTIsImV4cCI6MTU4Njg4NTI5Mn0.ZBKfsSAuuOmkxz8AOeM7_m0X_BNXIL_gWk9deo8QUjk");
		when(userRepository.findByUsername(user.getUserName())).thenReturn(Optional.of(user));
		when(jwtTokenProvider.createToken(user.getUserName(), Arrays.asList(user.getRoles()))).thenReturn(
				"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJsdWNoaW5vIiwicm9sZXMiOlsiVVNFUiJdLCJpYXQiOjE1ODY4ODE2OTIsImV4cCI6MTU4Njg4NTI5Mn0.ZBKfsSAuuOmkxz8AOeM7_m0X_BNXIL_gWk9deo8QUjk");
		
		response = loginService.login(authRequestBody);
		
		assertEquals(assertion.get("username"), response.get("username"));
		assertEquals(assertion.get("token"), response.get("token"));
	}

}
