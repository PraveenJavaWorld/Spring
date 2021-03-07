package com.nt.comp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("vehicle")
public class Vehicle {
	
	@Autowired
	@Qualifier("dEngine")
	private IEngine engg; //HAS-A property/Composition

	
	public void journey(String Source,String Destination) {
		engg.start();
		System.out.println("Journey Started at :: "+Source);
		System.out.println("Journey is going on ----");
		engg.stop();
		System.out.println("Journey Stopped at :: "+Destination);
	}
	
	

}
