package com.nt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.exception.InternalProblemException;
import com.nt.service.ShoppingStore;

public class AspectJAOPThrowsAdviceTest {

	public static void main(String[] args) {
		
		//create IOC Container
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get proxy class obj
		ShoppingStore proxy = ctx.getBean("service",ShoppingStore.class);
		//invoke b.method
		try {
			System.out.println("BillAmount :: "+proxy.calsBillAmount(10000, 5));
		} catch (InternalProblemException ipe) {
			ipe.printStackTrace();
		}
		System.out.println("===============================");
		try {
			System.out.println("BillAmount :: "+proxy.calsBillAmount(50000, 0));
		} catch (InternalProblemException ipe) {
			ipe.printStackTrace();
		}

	}

}
