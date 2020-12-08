package com.nt.factory;

import com.nt.comp.BudgetCar;
import com.nt.comp.ICar;
import com.nt.comp.LuxuryCar;
import com.nt.comp.SportsCar;

public class CarFactory {
	
	//factory method -- having factory pattern logic
	public static ICar getInstance(String type) {
		ICar car = null;
		if(type.equalsIgnoreCase("sports"))
			car = new SportsCar();
		else if(type.equalsIgnoreCase("budget"))
			car = new BudgetCar();
		else if(type.equalsIgnoreCase("luxury"))
			car = new LuxuryCar();
		else
			throw new IllegalArgumentException("Invalid Car Type");
		
		return car;
	}

}
