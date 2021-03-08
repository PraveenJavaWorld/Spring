package com.nt.beans;

public class BankLoanInterestCalculator {
	
	public float calculateIntAmt(float pAmt,float rate,float time) {
		System.out.println("BankLoanInterestCalculator.calculateIntAmt()(Compound Interest)");
		//Amount = p(1+r/100)^t-p
		return (float) (pAmt*Math.pow((1+(rate/100)), time))-pAmt;
	}

}
