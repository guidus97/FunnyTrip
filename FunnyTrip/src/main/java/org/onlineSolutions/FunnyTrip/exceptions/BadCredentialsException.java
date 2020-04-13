package org.onlineSolutions.FunnyTrip.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Username or password not valid")
public class BadCredentialsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BadCredentialsException(String message) {
		super(message);
	}
	
}
