package com.practice.microservice.limitsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.microservice.limitsservice.config.AllConfiguration;
import com.practice.microservice.limitsservice.model.LimitConfiguration;

@RestController
public class LimitsServiceConfigurationController {

	@Autowired
	AllConfiguration configuration;
	
	@GetMapping("/limits")
	public LimitConfiguration retriveFromConfiguration() {
		return new LimitConfiguration(configuration.getMaximum(),configuration.getMinimum());	
	}
}
