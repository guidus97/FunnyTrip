package org.onlineSolutions.FunnyTrip.exceptions.handler;

import org.onlineSolutions.FunnyTrip.exceptions.BadCredentialsException;
import org.onlineSolutions.FunnyTrip.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(BadCredentialsException.class)
	public final ResponseEntity<String> handleBadCredentialsException(){
		return new ResponseEntity<String>("Bad credentials", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<String> handleUserNotFoundException(){
		return new ResponseEntity<String>("User not found", HttpStatus.NOT_FOUND);
	}
}
