package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.nt.comp.Vehicle;
import com.nt.config.AppConfig;

public class StrategyDPTest {

	public static void main(String[] args) {
	
		
		//Create IOC Container
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		// get Vehicle object (target class obj)
		Vehicle vehicle = ctx.getBean("vehicle", Vehicle.class);	
		//invoke bussiness method
		vehicle.journey("Hyderabad", "Goa");
		
		//close Container
		((AbstractApplicationContext) ctx).close();
			
	}

}
