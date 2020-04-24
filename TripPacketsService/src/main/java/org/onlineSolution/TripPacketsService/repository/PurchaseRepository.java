package org.onlineSolution.TripPacketsService.repository;

import org.onlineSolution.TripPacketsService.model.Purchase;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends CrudRepository<Purchase, Integer>{

}
