package org.onlineSolution.TripPacketsService.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateProvider {

	@Bean
	public RestTemplate getInstance() {
		return new RestTemplate();
	}
}
