package org.onlineSolution.TripPacketsService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@SpringBootApplication
@EnableDiscoveryClient
@EnableEncryptableProperties
@EnableCaching
public class TripPacketsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TripPacketsServiceApplication.class, args);
	}

}
