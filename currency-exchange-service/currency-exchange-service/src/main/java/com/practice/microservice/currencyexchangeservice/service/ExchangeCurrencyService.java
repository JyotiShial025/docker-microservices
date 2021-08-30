package com.practice.microservice.currencyexchangeservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.microservice.currencyexchangeservice.model.ExchangeValue;
import com.practice.microservice.currencyexchangeservice.repo.CurrencyExchangeRepository;

@Service
public class ExchangeCurrencyService {

	@Autowired
	CurrencyExchangeRepository currencyExchangeRepository;

	public ExchangeValue findExchangeValue(String from, String to) {
		System.out.println("Service");
		ExchangeValue exchangeValue = currencyExchangeRepository.findByFromAndTo(from,to);
		System.out.println(exchangeValue.getConversionMultiple()+" "+exchangeValue.getFrom());
		return exchangeValue;
	}
	
	
}
