package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.comp.Vehicle;

public class StrategyDPTest {

	public static void main(String[] args) {
	
		
		//Create IOC Container
		//ApplicationContext ctx = new FileSystemXmlApplicationContext("src/com/nt/cfgs/applicationContext.xml");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		
		// get Vehicle object (target class obj)
		Vehicle vehicle = ctx.getBean("vehicle", Vehicle.class);	
		//invoke bussiness method
		vehicle.journey("Hyderabad", "Goa");
			
	}

}
