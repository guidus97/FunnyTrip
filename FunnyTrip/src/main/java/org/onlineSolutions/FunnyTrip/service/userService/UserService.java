package org.onlineSolutions.FunnyTrip.service.userService;

import java.util.ArrayList;
import java.util.List;

import org.onlineSolutions.FunnyTrip.exceptions.UserNotFoundException;
import org.onlineSolutions.FunnyTrip.model.user.User;
import org.onlineSolutions.FunnyTrip.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService implements I_UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	@CachePut(value = "users_list", key = "#id")
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
	@CachePut(value = "users_list", key = "#username")
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
	@CachePut(value = "users_list", key = "#email")
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
	@Cacheable(value = "users_list", key = "#id")
	public User getUserById(int id) {
		System.out.println("Getting from db...");
		return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
	}

	@Override
	@Cacheable(value = "users_list", key = "#username")
	public User getUserByUsername(String username) {
		System.out.println("Getting from db...");
		return userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException("User not found"));
	}

	@Override
	@Cacheable(value = "users_list", key = "#email")
	public User getUserByEmail(String email) {
		System.out.println("Getting from db...");
		return userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException("User not found"));
	}

	@Override
	@Cacheable(value = "users_list")
	public List<User> getAll() {

		List<User> list = new ArrayList<User>();
		
		System.out.println("Getting from db...");
		
		userRepository.findAll().forEach(list::add);
					
		return list;
	}

	@Override
	@CacheEvict(value = "users_list", key = "#id")
	public void deleteById(int id) {

		userRepository.deleteById(id);
	}

	@Override
	@CacheEvict(value = "users_list", key = "#email")
	public void deleteByEmail(String email) {
		userRepository.deleteByEmail(email);
	}

	@Override
	@CacheEvict(value = "users_list", key = "#username")
	public void deleteByUsername(String username) {
		userRepository.deleteByUsername(username);
	}
	
	
}
