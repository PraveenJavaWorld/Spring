package com.nt.beans;

import lombok.Setter;

@Setter
public class BankLoanInterestCalculator {
	
	private InterestAmountDetails details;
	
	public float calculateInterestAmount() {
		return (details.getPAmt()*details.getRoi()*details.getTime())/100.0f;
	}

}

