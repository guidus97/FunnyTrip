package org.onlineSolution.TripPacketsService.service;

import java.util.List;

import org.onlineSolution.TripPacketsService.exception.TripPacketNotFound;
import org.onlineSolution.TripPacketsService.model.Board;
import org.onlineSolution.TripPacketsService.model.Optional;
import org.onlineSolution.TripPacketsService.model.Room;
import org.onlineSolution.TripPacketsService.model.TripPacket;
import org.onlineSolution.TripPacketsService.repository.TripPacketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.kafka.core.KafkaTemplate;
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
	
	@Autowired
	private KafkaTemplate<String, TripPacket> kafka;
	
	private static final String TOPIC_ADD = "CatalogService";
	private static final String TOPIC_DELETE = "CatalogServiceDelete";

	@Override
	@CachePut(value = "trip", key = "#packet.id")
	public TripPacket addPacket(TripPacket packet) {
		
		TripPacket pack = packetRepository.save(packet);
		
		kafka.send(TOPIC_ADD, pack);
		
		return pack;
	}

	@Override
	@Cacheable(value = "trip", key = "#id")
	public TripPacket getById(int id) {
		return packetRepository.findById(id).orElseThrow(() -> new TripPacketNotFound("Packet not found"));
	}

	@Override
	@CachePut(value = "trip", key = "#id")
	public TripPacket updateById(TripPacket packet, int id) {
		
		TripPacket packet_to_update = packetRepository.findById(id).orElseThrow(() -> new TripPacketNotFound("Packet not found"));
		
		packet_to_update.setName(packet.getName());
		packet_to_update.setStart(packet.getStart());
		packet_to_update.setEnd(packet.getEnd());
		packet_to_update.setPrice(packet.getPrice());
		
		return packet_to_update;
	}

	@Override
	@CacheEvict(value = "trip", key = "#id")
	public void deletePacket(int id) {
		packetRepository.deleteById(id);
	}
	
	@Override
	@Cacheable(value = "trip")
	public List<TripPacket> getAll(){
		
		return packetRepository.getAll();
	}

	@Override
	@CachePut(value = "trip", key = "#optional.id")
	public Optional addOptionalToTripPacket(Optional optional, int id) throws Exception {
		
		TripPacket packet = packetRepository.findById(id).orElseThrow(() -> new TripPacketNotFound("Packet not found"));
		
		if (optional instanceof Room) {
			((Room) optional).setPacket(packet);
		}
		
		else if (optional instanceof Board) {
			((Board) optional).setPacket(packet);
		}
		
		else {
			throw new Exception("Bad credentials");
		}
		
		packet.addOptional(optional);
		
		return optional;
	}
	
	@Override
	@Cacheable(value = "trip")
	public List<Object> getAllOptionals(){
		return null;
	}

	@Override
	@Cacheable(value = "trip")
	public List<TripPacket> getAllTripPacketsForAllUsers() {
		return packetRepository.getTripPacketsForAllUsers();
	}

	@Override
	@Cacheable(value = "trip", key = "#user_id")
	public List<TripPacket> getAllTripPacketsByUserId(int user_id) {
		return packetRepository.getTripPacketsForSpecificUser(user_id);
	}
	
	
}
