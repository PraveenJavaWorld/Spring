package com.nt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.CarShowRoom;

public class AspectJAOPBeforeAdviceTest {

	public static void main(String[] args) {
		
		//create IOC Container
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Proxy class obj
		CarShowRoom proxy = ctx.getBean("service",CarShowRoom.class);
		//invoke b.method
		try {
			System.out.println(proxy.sellCar("Praveen", "Baleno", 1500000));
		} catch (Exception e) {
			e.printStackTrace();			
		}
		
		//close container
		ctx.close();

	}

}
