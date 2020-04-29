package org.onlineSolution.TripPacketsService.controller;

import org.onlineSolution.TripPacketsService.model.TripPacket;
import org.onlineSolution.TripPacketsService.service.I_TripPacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TripPacketController {

	@Autowired
	private I_TripPacketService packetService;
	
	@RequestMapping(value = "/addPacket", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST )
	public ResponseEntity<TripPacket> addPacket(@RequestBody TripPacket packet) {
		
		return new ResponseEntity<TripPacket>(packetService.addPacket(packet), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/getPacket/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<TripPacket> getPacketById(@PathVariable("id") int id){
		
		return new ResponseEntity<TripPacket>(packetService.getById(id), HttpStatus.OK);
	}
}
