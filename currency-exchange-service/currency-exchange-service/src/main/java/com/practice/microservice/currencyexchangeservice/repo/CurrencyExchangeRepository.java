package com.practice.microservice.currencyexchangeservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.practice.microservice.currencyexchangeservice.model.ExchangeValue;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<ExchangeValue, Integer>{

	//@Query("SELECT exchangeValue from ExchangeValue exchangeValue where exchangeValue.from =?1 and exchangeValue.to=?2")
	ExchangeValue findByFromAndTo(String from, String to);

}
