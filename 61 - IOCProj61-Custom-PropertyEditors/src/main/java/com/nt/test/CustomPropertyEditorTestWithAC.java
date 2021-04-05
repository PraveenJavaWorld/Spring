package com.nt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.BankLoanInterestCalculator;

public class CustomPropertyEditorTestWithAC {
	
	public static void main(String[] args) {
		//create IOC Container
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
			
		
		//get Target Spring Bean class obj
		BankLoanInterestCalculator blic = ctx.getBean("blic",BankLoanInterestCalculator.class);
		System.out.println("Interest Amount :: "+blic.calculateInterestAmount());
		
	
	}
	
	

}
