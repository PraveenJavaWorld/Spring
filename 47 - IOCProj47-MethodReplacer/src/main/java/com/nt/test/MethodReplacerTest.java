package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.BankLoanInterestCalculator;

public class MethodReplacerTest {

	public static void main(String[] args) {
		
		//create IOC Container
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Spring bean
		BankLoanInterestCalculator cal = ctx.getBean("intcal",BankLoanInterestCalculator.class);
		System.out.println(cal.getClass()+" "+cal.getClass().getSuperclass());
		//invoke methods
		System.out.println("Interest Amount :: "+cal.calculateIntAmt(100000, 2, 12));
		
		//close container
		((AbstractApplicationContext) ctx).close();

	}

}
