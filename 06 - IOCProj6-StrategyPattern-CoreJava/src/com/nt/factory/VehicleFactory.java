package com.nt.factory;

import com.nt.comp.DieselEngine;
import com.nt.comp.IEngine;
import com.nt.comp.PetrolEngine;
import com.nt.comp.Vehicle;

public class VehicleFactory {
	
	public static Vehicle getInstance(String engineType) {
		IEngine engg = null;
		//create Dependent class object
		if(engineType.equalsIgnoreCase("diesel"))
			engg = new DieselEngine();
		else if(engineType.equalsIgnoreCase("petrol"))
			engg = new PetrolEngine();
		else
			throw new IllegalArgumentException("Invalid Engine Type");
		
		//create Target class object
		Vehicle vehicle = new Vehicle();
		//assign Dependent object to Target object
		vehicle.setEngg(engg);
		
		return vehicle;
	}

}
