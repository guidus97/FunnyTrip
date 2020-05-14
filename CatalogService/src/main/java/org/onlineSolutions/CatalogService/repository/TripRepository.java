package org.onlineSolutions.CatalogService.repository;

import org.onlineSolutions.CatalogService.model.TripPacket;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends MongoRepository<TripPacket, Integer>{

}
