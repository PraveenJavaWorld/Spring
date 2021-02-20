package com.nt.beans;

import java.util.Arrays;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("fpkt")
public class Flipkart {
	
	@Autowired
	private Courier courier;
	
	public Flipkart() {
		System.out.println("Flipkart::0-param constructor");
	}
	//b.method
	public String shopping(String[] items,float[] prices) {
		float billAmt = 0.0f;
		for(float p:prices)
			billAmt = billAmt+p;
		//generate order id
		int oid = new Random().nextInt(10000);
		//use courier obj
		String msg = courier.deliver(oid);
		String finalMsg = Arrays.toString(items)+" are shopped having prices "+Arrays.toString(prices)+" with Total Bill Amount of "+billAmt+"\n "+ msg;
		return finalMsg;
	}

}
