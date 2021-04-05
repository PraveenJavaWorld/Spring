package com.nt.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.beans.BankLoanInterestCalculator;
import com.nt.config.AppConfig;

public class CustomPropertyEditorTestWithAC {
	
	public static void main(String[] args) {
		//create IOC Container
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
			
		
		//get Target Spring Bean class obj
		BankLoanInterestCalculator blic = ctx.getBean("blic",BankLoanInterestCalculator.class);
		System.out.println("Interest Amount :: "+blic.calculateInterestAmount());
		
	
	}
	
	

}
