package org.onlineSolutions.FunnyTrip.service.userService;

import java.util.List;

import org.onlineSolutions.FunnyTrip.model.user.User;

public interface I_UserService {

	User updateUserById(User user, int id);
	User updateUserByUsername(User user, String username);
	User updateUserByEmail(User user, String email);
	
	User getUserById(int id);
	User getUserByUsername(String username);
	User getUserByEmail(String email);
	List<User> getAll();
	
	void deleteById(int id);
	void deleteByEmail(String email);
	void deleteByUsername(String username);
}
