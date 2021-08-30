package com.practice.microservice.currencyexchangeservice.controller;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.practice.microservice.currencyexchangeservice.model.ExchangeValue;
import com.practice.microservice.currencyexchangeservice.service.ExchangeCurrencyService;

@RestController
public class CurrencyExchangeController {
	private static final Logger logger = Logger.getLogger(CurrencyExchangeController.class);
	@Autowired
	ExchangeCurrencyService exchangeCurrencyService;
	
	@Autowired
	Environment env;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retriveExchangeValue(@PathVariable String from, @PathVariable String to) {
		System.out.println("Controller");
		logger.infof("{}","Currency-exchange");
		ExchangeValue eValue = exchangeCurrencyService.findExchangeValue(from,to);	
		if(null != eValue)
			new RuntimeException("UNABLE TO FIND DATA FOR "+from+" AND "+ to);
		String port = env.getProperty("local.server.port");
		eValue.setPort(port);
		return eValue;
	}
}
