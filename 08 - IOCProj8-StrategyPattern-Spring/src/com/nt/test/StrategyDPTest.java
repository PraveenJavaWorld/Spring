package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.nt.comp.Vehicle;

public class StrategyDPTest {

	public static void main(String[] args) {
	
		
		//Create IOC Container
		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("com/nt/cfgs/applicationContext.xml"));
		// get Vehicle object (target class obj)
		Vehicle vehicle = factory.getBean("vehicle", Vehicle.class);	
		//invoke bussiness method
		vehicle.journey("Hyderabad", "Goa");
			
	}

}
