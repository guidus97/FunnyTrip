package org.onlineSolutions.FunnyTrip.service.userService;

import java.util.ArrayList;
import java.util.List;

import org.onlineSolutions.FunnyTrip.exceptions.UserNotFoundException;
import org.onlineSolutions.FunnyTrip.model.user.User;
import org.onlineSolutions.FunnyTrip.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService implements I_UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User updateUserById(User user, int id) {

		User userToUpdate = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));

		userToUpdate.setName(user.getName());
		userToUpdate.setLastName(user.getLastName());
		userToUpdate.setUserName(user.getUserName());
		userToUpdate.setEmail(user.getEmail());
		userToUpdate.setRoles(user.getRoles());
		userToUpdate.setActive(user.isActive());

		return userToUpdate;
	}

	@Override
	public User updateUserByUsername(User user, String username) {
		User userToUpdate = userRepository.findByUsername(username)
				.orElseThrow(() -> new UserNotFoundException("User not found"));

		userToUpdate.setName(user.getName());
		userToUpdate.setLastName(user.getLastName());
		userToUpdate.setUserName(user.getUserName());
		userToUpdate.setEmail(user.getEmail());
		userToUpdate.setRoles(user.getRoles());
		userToUpdate.setActive(user.isActive());

		return userToUpdate;

	}

	@Override
	public User updateUserByEmail(User user, String email) {

		User userToUpdate = userRepository.findByEmail(email)
				.orElseThrow(() -> new UserNotFoundException("User not found"));

		userToUpdate.setName(user.getName());
		userToUpdate.setLastName(user.getLastName());
		userToUpdate.setUserName(user.getUserName());
		userToUpdate.setEmail(user.getEmail());
		userToUpdate.setRoles(user.getRoles());
		userToUpdate.setActive(user.isActive());

		return userToUpdate;

	}

	@Override
	public User getUserById(int id) {
		return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
	}

	@Override
	public User getUserByUsername(String username) {
		return userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException("User not found"));
	}

	@Override
	public User getUserByEmail(String email) {
		return userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException("User not found"));
	}

	@Override
	public List<User> getAll() {

		List<User> list = new ArrayList<User>();
		
		userRepository.findAll().forEach(list::add);
		
		return list;
	}

	@Override
	public void deleteById(int id) {

		userRepository.deleteById(id);
	}

	@Override
	public void deleteByEmail(String email) {
		userRepository.deleteByEmail(email);
	}

	@Override
	public void deleteByUsername(String username) {
		userRepository.deleteByUsername(username);
	}
	
	
}
