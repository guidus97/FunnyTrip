package org.onlineSolutions.FunnyTrip.service.userDetailService;

import org.onlineSolutions.FunnyTrip.config.security.CustomUserDetails;
import org.onlineSolutions.FunnyTrip.model.user.User;
import org.onlineSolutions.FunnyTrip.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.findByUsername(username).orElse(null);
		
		if (user != null) {
			return new CustomUserDetails(user);
		}
		
		else {
			return null;
			
		}
	}

}
