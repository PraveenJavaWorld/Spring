package com.nt.comp;

public class Vehicle {
	
	private IEngine engg; //HAS-A property/Composition

	public void setEngg(IEngine engg) {
		this.engg = engg;
	}
	
	public void journey(String Source,String Destination) {
		engg.start();
		System.out.println("Journey Started at :: "+Source);
		System.out.println("Journey is going on ----");
		engg.stop();
		System.out.println("Journey Stopped at :: "+Destination);
	}
	
	

}
