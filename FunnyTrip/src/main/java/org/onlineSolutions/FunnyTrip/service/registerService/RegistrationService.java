package org.onlineSolutions.FunnyTrip.service.registerService;

import org.onlineSolutions.FunnyTrip.model.user.User;
import org.onlineSolutions.FunnyTrip.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService implements I_RegistrationService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	@Override
	@CachePut(value = "users_list", key = "#user")
	public User registerUser(User user) {
		
		user.setPassword(bcrypt.encode(user.getPassword()));
		
		return userRepository.save(user);
	}
}
