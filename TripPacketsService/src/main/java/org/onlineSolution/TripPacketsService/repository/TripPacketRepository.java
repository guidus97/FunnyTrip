package org.onlineSolution.TripPacketsService.repository;

import org.onlineSolution.TripPacketsService.model.TripPacket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripPacketRepository extends CrudRepository<TripPacket, Integer>{

}
