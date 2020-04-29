package org.onlineSolutions.FunnyTrip;

import org.onlineSolutions.FunnyTrip.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
@EnableCaching
@EnableEncryptableProperties
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class FunnyTripApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(FunnyTripApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(FunnyTripApplication.class);
	}

}
