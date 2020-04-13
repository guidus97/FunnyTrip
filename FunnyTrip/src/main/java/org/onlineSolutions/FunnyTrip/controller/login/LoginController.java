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

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class LoginController {

	@Autowired
	private I_LoginService loginService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> login(@RequestBody AuthRequestBody authRequestBody){
		
		try {
			return ResponseEntity.ok(loginService.login(authRequestBody));
			
		}catch (AuthenticationException e) {
			throw new BadCredentialsException("Username or password not valid");
		}
	}
}
