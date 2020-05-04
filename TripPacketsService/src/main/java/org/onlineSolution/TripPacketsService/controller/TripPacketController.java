package org.onlineSolution.TripPacketsService.controller;

import java.util.List;

import org.onlineSolution.TripPacketsService.model.Optional;
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
	
	@RequestMapping(value = "/getAllPacketsPurchased", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<List<TripPacket>> getAllPurchasedPacketsFromAllUsers(){
		
		return new ResponseEntity<List<TripPacket>>(packetService.getAllTripPacketsForAllUsers(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getAllPacketsForUser/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<List<TripPacket>> getAllPurchasedPacketsForUserById(@PathVariable("id") int id){
		
		return new ResponseEntity<List<TripPacket>>(packetService.getAllTripPacketsByUserId(id), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<List<TripPacket>> getAll(){
		
		return new ResponseEntity<List<TripPacket>>(packetService.getAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/updatePacket/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
	public ResponseEntity<TripPacket> updatePacket(@RequestBody TripPacket tripPacket, @PathVariable("id") int id){
		
		return new ResponseEntity<TripPacket>(packetService.updateById(tripPacket, id), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/deletePacket/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletePacket(@PathVariable("id") int id){
		
		packetService.deletePacket(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getPacket/{id}/addOptional", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
	public ResponseEntity<Optional> addOptionalToPacket(@RequestBody Optional optional, @PathVariable("id") int id) throws Exception{
		return new ResponseEntity<Optional>(packetService.addOptionalToTripPacket(optional, id), HttpStatus.CREATED);
	}
}
