package com.practice.microservice.currencyconversionservice.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.practice.microservice.currencyconversionservice.model.CurrencyConversion;
import com.practice.microservice.currencyconversionservice.service.CurrencyconversionFeignProxy;


@RestController
public class CurrencyConverterController {
	private static final Logger logger = Logger.getLogger(CurrencyConverterController.class.getName());
	@Autowired
	private CurrencyconversionFeignProxy proxy;
	
	@Autowired
	private Environment env;
	
	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion convertCurrency(@PathVariable String from,@PathVariable String to,@PathVariable int quantity) {
		
		logger.info("Currency-converter");
		Map<String, String> uriVariables = new HashMap<String, String>();
		uriVariables.put("from",from);
		uriVariables.put("to",to);
		ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",CurrencyConversion.class,uriVariables);
		CurrencyConversion response = responseEntity.getBody();

		return new CurrencyConversion(response.getId(),from,to,response.getConversionMultiple(),quantity,quantity*response.getConversionMultiple(),response.getPort());
	}
	
	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion convertCurrencyFeign(@PathVariable String from,@PathVariable String to,@PathVariable int quantity) {
	//	logger.infof("{}","Currency-converter-feign");
		logger.info("Currency-converter-feign");
		CurrencyConversion response = proxy.retriveExchangeValue(from, to);

		return new CurrencyConversion(response.getId(),from,to,response.getConversionMultiple(),quantity,quantity*response.getConversionMultiple(),response.getPort() +" feign");
	}


}
