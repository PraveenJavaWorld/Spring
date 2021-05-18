package com.nt.service;

import org.springframework.stereotype.Service;

@Service("service")
public class BankService {
	
	public double calSimpleInterest(float pAmt,float rate,float time) {
		System.out.println("BankService.calSimpleInterest()");
		return (pAmt*rate*time)/100.0f;
	}
	
	public double calCompoundInterest(float pAmt,float rate,float time) {
		System.out.println("BankService.calCompoundInterest()");
		return (pAmt*Math.pow(1+rate/100, time))-pAmt;
	}

}
