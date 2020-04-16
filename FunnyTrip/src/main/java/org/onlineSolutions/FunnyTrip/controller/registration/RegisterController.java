package org.onlineSolutions.FunnyTrip.controller.registration;

import org.onlineSolutions.FunnyTrip.model.user.User;
import org.onlineSolutions.FunnyTrip.service.registerService.I_RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
@Api(value = "Register controller", description = "Controller for registration service")
public class RegisterController {
	
	@Autowired
	private I_RegistrationService i_RegistrationService;
	
	@RequestMapping(value = "/registerUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	@ApiOperation(value = "Add a user to the database", response = ResponseEntity.class, protocols = "HTTP", produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "User created"),
			@ApiResponse(code = 500, message = "Failed to register the user")
	})
	public ResponseEntity<User> registerUser(@RequestBody User user) {
		
		User user2 = this.i_RegistrationService.registerUser(user);
		
		if (user2 != null) {
			return new ResponseEntity<User>(user2, HttpStatus.CREATED);
		}
		
		else {
			return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
