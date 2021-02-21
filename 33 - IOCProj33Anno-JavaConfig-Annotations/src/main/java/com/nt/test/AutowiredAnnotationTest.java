package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.Flipkart;

public class AutowiredAnnotationTest {

	public static void main(String[] args) {
		
		//create IOC Container
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get target bean class
		Flipkart fpkt = ctx.getBean("fpkt",Flipkart.class);
		//invoke b.method
		String msg = fpkt.shopping(new String[] {"Shirt","Trouser","Shoes"}, new float[] {1200,2300,1500});
		System.out.println(msg);
		
		//close Container
		((AbstractApplicationContext) ctx).close();
		

	}

}
