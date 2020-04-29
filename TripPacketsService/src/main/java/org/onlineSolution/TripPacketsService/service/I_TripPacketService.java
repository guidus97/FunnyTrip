package org.onlineSolution.TripPacketsService.service;

import java.util.List;

import org.onlineSolution.TripPacketsService.model.Optional;
import org.onlineSolution.TripPacketsService.model.TripPacket;

public interface I_TripPacketService {

	TripPacket addPacket(TripPacket packet);
	TripPacket getById(int id);
	TripPacket updateById(TripPacket packet, int id);
	void deletePacket(int id);
	
	Optional addOptionalToTripPacket(Optional optional, int id);
	
	List<TripPacket> getAllTripPacketsForAllUsers();
	List<TripPacket> getAllTripPacketsByUserId(int user_id);
	
	List<Object> getAllOptionals();
}
