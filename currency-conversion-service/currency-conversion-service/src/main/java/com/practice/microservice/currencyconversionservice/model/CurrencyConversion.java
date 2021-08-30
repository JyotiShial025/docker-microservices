package com.practice.microservice.currencyconversionservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyConversion {


	private int id;
	private String from;
	private String to;
	private int conversionMultiple;
	private int quantity;
	private int totalQuantity;
	private String port;


}
