package org.onlineSolutions.CatalogService.service;

import org.onlineSolutions.CatalogService.model.TripPacket;
import org.onlineSolutions.CatalogService.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class CatalogService {

	@Autowired
	private TripRepository repository;

	@KafkaListener(topics = "CatalogService", groupId = "json_id", containerFactory = "listenerContainerFactory")
	public TripPacket saveConsumedTrip(TripPacket packet) {

		System.out.println("Received json: " + packet);
		return repository.insert(packet);
	}

	@KafkaListener(topics = "CatalogService", groupId = "string_id", containerFactory = "listenerString")
	public void consumeString(String string) {

		System.out.println("Received message: " + string);
	}

}
