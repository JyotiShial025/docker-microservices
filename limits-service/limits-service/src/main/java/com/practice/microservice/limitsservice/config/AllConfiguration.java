package com.practice.microservice.limitsservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@ConfigurationProperties("limits-service")
@Getter @Setter
public class AllConfiguration {

	private int maximum;
	private int minimum;

	
}
