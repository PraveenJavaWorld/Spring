package com.nt.model;

import java.util.Map;

import lombok.Data;

@Data
public class Address {
	
	private String doorNo;
	private String street;
	private String city;
	private Map<String,Long> mobilePrices; 

}
