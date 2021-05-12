package com.nt.service;

public class CarShowRoom {
	
	public String sellCar(String custName,String carModel,double price) {
		
		if(carModel.equalsIgnoreCase("Baleno"))
			return "Car "+ carModel +" is  sold at Price :: "+ price + " to Customer :: "+custName;
		else
			return "Car "+ carModel +" is  Not available for Sale";
		
	}

}
