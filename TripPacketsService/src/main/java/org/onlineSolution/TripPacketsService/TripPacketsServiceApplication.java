package org.onlineSolution.TripPacketsService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TripPacketsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TripPacketsServiceApplication.class, args);
	}

}
