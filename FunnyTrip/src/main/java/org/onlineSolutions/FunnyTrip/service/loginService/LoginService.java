package org.onlineSolutions.FunnyTrip.service.loginService;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.onlineSolutions.FunnyTrip.config.security.AuthRequestBody;
import org.onlineSolutions.FunnyTrip.config.security.JwtTokenProvider;
import org.onlineSolutions.FunnyTrip.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements I_LoginService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	
	public Map<Object, Object> login(AuthRequestBody authRequestBody){
		
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequestBody.getUsername(), authRequestBody.getPassword()));
		
		String username = userRepository.findByUsername(authRequestBody.getUsername()).orElse(null).getUserName();
		
		if (username != null) {
			String token = jwtTokenProvider.createToken(username, Arrays.asList(userRepository.findByUsername(username).orElse(null).getRoles()));
			Map<Object, Object> response = new HashMap<>();
			
			response.put("username", username);
			response.put("token", token);
			
			return response;
		}
		
		return null;
	}
}
