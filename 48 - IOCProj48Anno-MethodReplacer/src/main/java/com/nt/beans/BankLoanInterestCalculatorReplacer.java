package com.nt.beans;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;
import org.springframework.stereotype.Component;

@Component("intcalReplacer")
public class BankLoanInterestCalculatorReplacer implements MethodReplacer {

	@Override
	public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
		System.out.println("BankLoanInterestCalculatorReplacer.reimplement(-,-,-)(Simple Interest)");
		float pAmt = (float) args[0];
		float rate = (float) args[1];
		float time = (float) args[2];
		//Simple Interest Calculation
		return (pAmt*rate*time)/100.0f;
	}

}
