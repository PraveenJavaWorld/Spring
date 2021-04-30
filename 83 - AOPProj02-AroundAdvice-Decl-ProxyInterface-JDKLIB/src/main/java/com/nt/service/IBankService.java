package com.nt.service;

public interface IBankService {
	
	public double calSimpleInterest(float pAmt,float rate,float time);
	public double calCompoundInterest(float pAmt,float rate,float time);

}
