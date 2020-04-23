package org.onlineSolutions.FunnyTrip.controller.user;

import java.util.List;

import org.onlineSolutions.FunnyTrip.model.user.User;
import org.onlineSolutions.FunnyTrip.service.userService.I_UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
@Api(value = "User controller", description = "User controller used to modify, give and delete user details")
public class UserController {

	@Autowired
	private I_UserService i_UserService;
	
	@RequestMapping(value = "/account/modifyUserById/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
	@ApiOperation(value = "Modify the user by id", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, httpMethod = "PUT")
	@ApiResponses({
	
		@ApiResponse(code = 200, message = "User updated"),
		@ApiResponse(code = 404, message = "User not found"),
		@ApiResponse(code = 403, message = "Access forbidden to this path"),
		@ApiResponse(code = 401, message = "User unauthorized"),
		@ApiResponse(code = 500, message = "Update failed due to server error")
	})
	public ResponseEntity<User> updateById(@ApiParam(value = "The user to update", required = true) @RequestBody User user, @PathVariable("id") int id) {
		
		return new ResponseEntity<User>(i_UserService.updateUserById(user, id), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/account/modifyUserByEmail/{email}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
	@ApiOperation(value = "Modify the user by email", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, httpMethod = "PUT")
	@ApiResponses({
	
		@ApiResponse(code = 200, message = "User updated"),
		@ApiResponse(code = 404, message = "User not found"),
		@ApiResponse(code = 403, message = "Access forbidden to this path"),
		@ApiResponse(code = 401, message = "User unauthorized"),
		@ApiResponse(code = 500, message = "Update failed due to server error")
	})
	public ResponseEntity<User> updateByEmail(@ApiParam(value = "The user to update", required = true) @RequestBody User user, @PathVariable("email") String email) {
		
		return new ResponseEntity<User>(i_UserService.updateUserByEmail(user, email), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/account/modifyUserByUsername/{username}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
	@ApiOperation(value = "Modify the user by username", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, httpMethod = "PUT")
	@ApiResponses({
	
		@ApiResponse(code = 200, message = "User updated"),
		@ApiResponse(code = 404, message = "User not found"),
		@ApiResponse(code = 403, message = "Access forbidden to this path"),
		@ApiResponse(code = 401, message = "User unauthorized"),
		@ApiResponse(code = 500, message = "Update failed due to server error")
	})
	public ResponseEntity<User> updateByUsername(@ApiParam(value = "The user to update", required = true) @RequestBody User user, @PathVariable("username") String username) {
		
		return new ResponseEntity<User>(i_UserService.updateUserByUsername(user, username), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/account/getUserById/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	@ApiOperation(value = "Give the user by id", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, httpMethod = "GET")
	@ApiResponses({
	
		@ApiResponse(code = 200, message = "User give"),
		@ApiResponse(code = 404, message = "User not found"),
		@ApiResponse(code = 403, message = "Access forbidden to this path"),
		@ApiResponse(code = 401, message = "User unauthorized"),
		@ApiResponse(code = 500, message = "Give failed due to server error")
	})
	public ResponseEntity<User> getUserById(@PathVariable("id") int id) {
		
		return new ResponseEntity<User>(i_UserService.getUserById(id), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/account/getUserByEmail/{email}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	@ApiOperation(value = "Give the user by email", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, httpMethod = "GET")
	@ApiResponses({
	
		@ApiResponse(code = 200, message = "User give"),
		@ApiResponse(code = 404, message = "User not found"),
		@ApiResponse(code = 403, message = "Access forbidden to this path"),
		@ApiResponse(code = 401, message = "User unauthorized"),
		@ApiResponse(code = 500, message = "Give failed due to server error")
	})
	public ResponseEntity<User> getUserByEmail(@PathVariable("email") String email) {
		
		return new ResponseEntity<User>(i_UserService.getUserByEmail(email), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/account/getUserByUsername/{username}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	@ApiOperation(value = "Give the user by username", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, httpMethod = "GET")
	@ApiResponses({
	
		@ApiResponse(code = 200, message = "User give"),
		@ApiResponse(code = 404, message = "User not found"),
		@ApiResponse(code = 403, message = "Access forbidden to this path"),
		@ApiResponse(code = 401, message = "User unauthorized"),
		@ApiResponse(code = 500, message = "Give failed due to server error")
	})
	public ResponseEntity<User> getUserByUsername(@PathVariable("username") String username) {
		
		return new ResponseEntity<User>(i_UserService.getUserByUsername(username), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/admin/privileges/getAllUsers", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	@ApiOperation(value = "Give all the users", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, httpMethod = "GET")
	@ApiResponses({
	
		@ApiResponse(code = 200, message = "Users give"),
		@ApiResponse(code = 403, message = "Access forbidden to this path"),
		@ApiResponse(code = 401, message = "User unauthorized"),
		@ApiResponse(code = 500, message = "Give failed due to server error")
	})
	public ResponseEntity<List<User>> getAll() {
		
		return new ResponseEntity<List<User>>(i_UserService.getAll(), HttpStatus.OK);
	}
	@RequestMapping(value = "/account/deleteUserById/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
	@ApiOperation(value = "Delete the user by id", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, httpMethod = "DELETE")
	@ApiResponses({
	
		@ApiResponse(code = 200, message = "User deleted"),
		@ApiResponse(code = 404, message = "User not found"),
		@ApiResponse(code = 403, message = "Access forbidden to this path"),
		@ApiResponse(code = 401, message = "User unauthorized"),
		@ApiResponse(code = 500, message = "Deletion failed due to server error")
	})
	public ResponseEntity<Void> deleteById(@ApiParam(value = "The user to update", required = true) @RequestBody User user, @PathVariable("id") int id) {
		
		i_UserService.deleteById(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/account/deleteUserByEmail/{email}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
	@ApiOperation(value = "Delete the user by email", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, httpMethod = "DELETE")
	@ApiResponses({
	
		@ApiResponse(code = 200, message = "User deleted"),
		@ApiResponse(code = 404, message = "User not found"),
		@ApiResponse(code = 403, message = "Access forbidden to this path"),
		@ApiResponse(code = 401, message = "User unauthorized"),
		@ApiResponse(code = 500, message = "Deletion failed due to server error")
	})
	public ResponseEntity<Void> deleteByEmail(@ApiParam(value = "The user to update", required = true) @RequestBody User user, @PathVariable("email") String email) {
		
		i_UserService.deleteByEmail(email);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/account/deleteUserByUsername/{username}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
	@ApiOperation(value = "Delete the user by username", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, httpMethod = "DELETE")
	@ApiResponses({
	
		@ApiResponse(code = 200, message = "User deleted"),
		@ApiResponse(code = 404, message = "User not found"),
		@ApiResponse(code = 403, message = "Access forbidden to this path"),
		@ApiResponse(code = 401, message = "User unauthorized"),
		@ApiResponse(code = 500, message = "Deletion failed due to server error")
	})
	public ResponseEntity<Void> deleteByUsername(@ApiParam(value = "The user to delete", required = true) @RequestBody User user, @PathVariable("username") String username) {
		
		i_UserService.deleteByUsername(username);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
