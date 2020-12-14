package com.nt.test;

import com.nt.comp.Flipkart;
import com.nt.factory.FlipkartFactory;

public class StrategyDPTest {

	public static void main(String[] args) {
		
		//create target class object
		Flipkart flipkart = null;
		flipkart = FlipkartFactory.getInstance("bluedart");
		System.out.println(flipkart.shopping(new String[] {"Mask","Sanitizer","Hand Gloves"}, new float[] {200,400,100}));

	}

}
