package com.nt.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@Component("blic")
@PropertySource(value = "com/nt/commons/info.properties")
public class BankLoanInterestCalculator {
	@Value("${amt.details}")
	private InterestAmountDetails details;
	
	public float calculateInterestAmount() {
		return (details.getPAmt()*details.getRoi()*details.getTime())/100.0f;
	}

}

