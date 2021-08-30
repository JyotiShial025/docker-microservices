package com.practice.microservice.currencyconversionservice.service;

//import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.practice.microservice.currencyconversionservice.model.CurrencyConversion;

//@RibbonClient(name="currency-exchange-service") //won't work for Spring 2.4 or above version
//@FeignClient(name="currency-exchange-service",url = "localhost:8000")
//when added eureka client remove url to give loadbalancing
@FeignClient(name="currency-exchange-service")
public interface CurrencyconversionFeignProxy {

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion retriveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);
}
