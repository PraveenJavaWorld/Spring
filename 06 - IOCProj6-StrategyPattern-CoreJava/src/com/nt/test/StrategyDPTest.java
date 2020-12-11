package com.nt.test;

import com.nt.comp.Vehicle;
import com.nt.factory.VehicleFactory;

public class StrategyDPTest {

	public static void main(String[] args) {
		
		try {
			// get Vehicle object (target class obj)
			Vehicle vehicle = VehicleFactory.getInstance("Diesel");
			//invoke bussiness method
			vehicle.journey("Hyderabad", "Goa");
		} catch (IllegalArgumentException iae) {
			iae.printStackTrace();
		}

	}

}
