package org.onlineSolutions.FunnyTrip.service.registerService;

import org.onlineSolutions.FunnyTrip.model.user.User;
import org.onlineSolutions.FunnyTrip.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService implements I_RegistrationService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User registerUser(User user) {
		
		return userRepository.save(user);
	}
}
