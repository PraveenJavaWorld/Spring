package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.Customer;

public class FactoryBeanTest {

	public static void main(String[] args) {
		
		//create IOC Container
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Spring bean
		Customer cust = ctx.getBean("cust",Customer.class);
		//invoke b.methods
		cust.showProductDetails();
		
		//close containers
		((AbstractApplicationContext) ctx).close();

	}

}
