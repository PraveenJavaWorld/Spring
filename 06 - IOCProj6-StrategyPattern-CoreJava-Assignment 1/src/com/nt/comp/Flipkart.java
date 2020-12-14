package com.nt.comp;

import java.util.Arrays;
import java.util.Random;

public class Flipkart {
	
	private ICourier courier;

	public void setCourier(ICourier courier) {
		this.courier = courier;
	}
	
	public String shopping(String[] items,float[] prices) {
		float billAmt = 0;
		int orderId = 0;
		String msg = null;
		Random random = null;
		
		//calculate Bill Amount
		
		for(float p:prices)
			billAmt = billAmt+p;
		//generate random order id dynamically
		random = new Random();
		orderId = random.nextInt(10000);
		//use courier service  for delivering products
		msg = courier.deliver(orderId);
		
		courier.dispatchDate();
		courier.deliveryDate();
		
		 // return bill Amt and courier details to customer
		return  Arrays.toString(items)+" are purchased  having prices "+Arrays.toString(prices)+"  with bill amount "+billAmt+ "----"+ msg;
		
	}

}
