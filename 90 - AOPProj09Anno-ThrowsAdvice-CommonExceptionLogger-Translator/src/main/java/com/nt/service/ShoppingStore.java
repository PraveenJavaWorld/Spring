package com.nt.service;

import org.springframework.stereotype.Service;

@Service("service")
public class ShoppingStore {
	
	public double calsBillAmount(double price,double qty) {
		System.out.println("ShoppingStore.calsBillAmount()");
		if(price<=0.0 || qty<=0.0)
			throw new IllegalArgumentException("invalid price and qty");
		//calculate BillAmount
		double billAmt = price*qty;
		return billAmt;
	}

}
