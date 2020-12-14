package com.nt.test;

import com.nt.comp.Vehicle;
import com.nt.factory.VehicleFactory;

public class StrategyDPTest {

	public static void main(String[] args) {
	
		// get Vehicle object (target class obj)
		Vehicle vehicle = VehicleFactory.getInstance();
		//invoke bussiness method
		vehicle.journey("Hyderabad", "Goa");
			
	}

}
