package org.onlineSolutions.FunnyTrip;

import org.onlineSolutions.FunnyTrip.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaServer
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class FunnyTripApplication {

	public static void main(String[] args) {
		SpringApplication.run(FunnyTripApplication.class, args);
	}

}
