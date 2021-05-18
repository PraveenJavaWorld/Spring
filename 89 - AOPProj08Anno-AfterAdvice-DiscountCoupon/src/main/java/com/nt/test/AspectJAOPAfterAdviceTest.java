package com.nt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.OnlineStore;

public class AspectJAOPAfterAdviceTest {

	public static void main(String[] args) {
		
				//create IOC Container
				ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
				//get proxy class obj
				OnlineStore proxy = ctx.getBean("service",OnlineStore.class);
				
				try {
					System.out.println("Bill Amount :: "+proxy.shopping(new String[] {"Azax","Limcee","Doxt-sl","Ivermectin","LevoCitrizen"}, 
																	new double[] {400,300,800,1200,50}));
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				//close container
				ctx.close();

	}

}
