package com.practice.microservice.currencyexchangeservice.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Exchange_Value")
@Setter @Getter @NoArgsConstructor
public class ExchangeValue {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="currency_from")
	private String from;
	
	@Column(name="currency_to")
	private String to;
	
	@Column(name="conversion_multiple")
	private int conversionMultiple;
	
	private String port;
	
	public ExchangeValue(String from, String to, int conversionMultiple) {
		super();
		//this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
	}
	
}
