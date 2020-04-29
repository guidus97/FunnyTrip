package org.onlineSolution.TripPacketsService.service;

import java.util.List;

import org.onlineSolution.TripPacketsService.exception.TripPacketNotFound;
import org.onlineSolution.TripPacketsService.model.Optional;
import org.onlineSolution.TripPacketsService.model.TripPacket;
import org.onlineSolution.TripPacketsService.repository.TripPacketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service
@Transactional
public class TripPacketService implements I_TripPacketService {

	@Autowired
	private TripPacketRepository packetRepository;
	
	@Autowired
	private RestTemplate restclient;

	@Override
	public TripPacket addPacket(TripPacket packet) {
		return packetRepository.save(packet);
	}

	@Override
	public TripPacket getById(int id) {
		return packetRepository.findById(id).orElse(null);
	}

	@Override
	public TripPacket updateById(TripPacket packet, int id) {
		
		TripPacket packet_to_update = packetRepository.findById(id).orElseThrow(() -> new TripPacketNotFound("Packet not found"));
		
		packet_to_update.setName(packet.getName());
		packet_to_update.setStart(packet.getStart());
		packet_to_update.setEnd(packet.getEnd());
		packet_to_update.setPrice(packet.getPrice());
		
		return packet_to_update;
	}

	@Override
	public void deletePacket(int id) {
		packetRepository.deleteById(id);
	}

	@Override
	public Optional addOptionalToTripPacket(Optional optional, int id) {
		
		TripPacket packet = packetRepository.findById(id).orElseThrow(() -> new TripPacketNotFound("Packet not found"));
		
		packet.addOptional(optional);
		
		return optional;
	}
	
	public List<Object> getAllOptionals(){
		return null;
	}

	@Override
	public List<TripPacket> getAllTripPacketsForAllUsers() {
		return packetRepository.getTripPacketsForAllUsers();
	}

	@Override
	public List<TripPacket> getAllTripPacketsByUserId(int user_id) {
		return packetRepository.getTripPacketsForSpecificUser(user_id);
	}
	
	
}
