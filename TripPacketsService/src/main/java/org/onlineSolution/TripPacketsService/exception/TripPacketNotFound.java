package org.onlineSolution.TripPacketsService.exception;

public class TripPacketNotFound extends RuntimeException {

	
	private static final long serialVersionUID = 1L;

	public TripPacketNotFound() {
		super();
	}
	
	public TripPacketNotFound(String message) {
		super(message);
	}
}
