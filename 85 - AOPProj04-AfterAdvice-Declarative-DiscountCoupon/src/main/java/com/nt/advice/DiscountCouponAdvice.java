package com.nt.advice;

import java.io.FileWriter;
import java.io.Writer;

import org.aspectj.lang.JoinPoint;

public class DiscountCouponAdvice {
	
	public void generateCoupon(JoinPoint jp,double billAmt) throws Throwable{
		String couponMsg = null;
		if(billAmt>=20000)
			couponMsg = "Avail 30% Discount on next Purchase";
		else if(billAmt>=10000)
			couponMsg = "Avail 15% Discount on next Purchase";
		else
			couponMsg = "Avail 5% Discount on next Purchase";
		
		//generate the coupon
		Writer writer = new FileWriter("F:/Java/Coupon.txt");
		writer.write(couponMsg);
		writer.flush();
		writer.close();
	}

}