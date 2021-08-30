package com.practice.microservice.currencyexchangeservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {

	Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);
	
	//for temporary failure - default retey is 3
	//@Retry(name="sample-api", fallbackMethod = "fallBack")
	
	//for service down
	//@CircuitBreaker(name="sample-api", fallbackMethod = "fallBack")
	@RateLimiter(name="default")
	//for concurrent call
	@Bulkhead(name="default")
	@GetMapping("/sample-api")
	public String samplApi() {
		logger.info("Sample Api call received");
//		ResponseEntity<String> entity = new RestTemplate().getForEntity("http://loalhost:8080/dummy", String.class);
//		return entity.getBody();
		return "sample-api";
	}
	
	public String fallBack(Exception e) {
		return "fallback-response";
	}
}
