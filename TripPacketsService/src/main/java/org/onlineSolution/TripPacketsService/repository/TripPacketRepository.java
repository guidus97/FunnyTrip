package org.onlineSolution.TripPacketsService.repository;

import java.util.List;

import org.onlineSolution.TripPacketsService.model.TripPacket;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TripPacketRepository extends CrudRepository<TripPacket, Integer>{

	@Query(value = "select tp.id, tp.\"name\", tp.\"start\", tp.end_trip, tp.price from public.trip_packet tp\r\n" + 
			"INNER join purchase on tp.id = purchase.trip_pack_id\r\n" + 
			"INNER join \"user\" on purchase.user_id = \"user\".id", nativeQuery = true)
	List<TripPacket> getTripPacketsForAllUsers();
	
	@Query(value = "select tp.id, tp.\"name\", tp.\"start\", tp.end_trip, tp.price from public.trip_packet tp\r\n" + 
			"INNER join purchase on tp.id = purchase.trip_pack_id\r\n" + 
			"INNER join \"user\" on purchase.user_id = \"user\".id\r\n" + 
			"where \"user\".id = :id", nativeQuery = true)
	List<TripPacket> getTripPacketsForSpecificUser(@Param("id") int user_id);
	
	@Query(value = "select * from public.trip_packet", nativeQuery = true)
	List<TripPacket> getAll();
}
