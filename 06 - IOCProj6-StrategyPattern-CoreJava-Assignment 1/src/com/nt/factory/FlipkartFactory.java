package com.nt.factory;

import com.nt.comp.BlueDart;
import com.nt.comp.DTDC;
import com.nt.comp.EcomExpress;
import com.nt.comp.Flipkart;
import com.nt.comp.ICourier;

public class FlipkartFactory {
	
	public static Flipkart getInstance(String courierName) {
		ICourier courier = null;
		//create Dependent Class Object
		if(courierName.equalsIgnoreCase("bluedart"))
			courier = new BlueDart();
		else if(courierName.equalsIgnoreCase("dtdc"))
			courier = new DTDC();
		else if(courierName.equalsIgnoreCase("ecomexpress"))
			courier = new EcomExpress();
		else
			throw new IllegalArgumentException("Invalid Courier");
		
		//create target Class object
		Flipkart flipkart = new Flipkart();
		//assign dependent class object to taget class object
		flipkart.setCourier(courier);
		
		return flipkart;
	}

}
