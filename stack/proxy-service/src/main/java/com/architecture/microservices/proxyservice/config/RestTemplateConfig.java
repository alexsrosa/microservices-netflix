package com.architecture.microservices.proxyservice.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
	private final RestTemplateBuilder restTemplateBuilder;

	public RestTemplateConfig(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplateBuilder = restTemplateBuilder;
	}

	@LoadBalanced
	@Bean
	public RestTemplate restTemplate() {
		return restTemplateBuilder.build();
	}
}
