package org.onlineSolutions.FunnyTrip.controller.login;

import org.onlineSolutions.FunnyTrip.config.security.AuthRequestBody;
import org.onlineSolutions.FunnyTrip.exceptions.BadCredentialsException;
import org.onlineSolutions.FunnyTrip.service.loginService.I_LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
@Api(value = "Login Service", description = "Login controller that define a single endpoint for authenticate the user")
public class LoginController {

	@Autowired
	private I_LoginService loginService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Login a user to the system", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, httpMethod = "POST")
	@ApiResponses({
		@ApiResponse(code = 200, message = "User logged successfully"),
		@ApiResponse(code = 401, message = "User unauthorized"),
		@ApiResponse(code = 500, message = "Authentication failed due to server errors"),
		@ApiResponse(code = 403, message = "Access forbidden to this path")
	})
	public ResponseEntity<?> login(@ApiParam(value = "Auth credentials for get the jwt", required = true) @RequestBody AuthRequestBody authRequestBody){
		
		try {
			return ResponseEntity.ok(loginService.login(authRequestBody));
			
		}catch (AuthenticationException e) {
			throw new BadCredentialsException("Username or password not valid");
		}
	}
}
