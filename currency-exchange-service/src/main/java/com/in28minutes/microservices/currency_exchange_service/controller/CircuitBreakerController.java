package com.in28minutes.microservices.currency_exchange_service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class CircuitBreakerController {

	private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);
	
	@GetMapping("/sample-api")
	//@Retry(name= "sample-api", fallbackMethod="hardcodedResponse")
	@CircuitBreaker(name= "default", fallbackMethod="hardcodedResponse")
	public String sampleAPI() {
		logger.info("Sample API call");
		ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost8080/abc-def", String.class);
		return forEntity.getBody();
	}
	
	public String hardcodedResponse(Exception ex) {
		return "fallback-response";
	}
}
