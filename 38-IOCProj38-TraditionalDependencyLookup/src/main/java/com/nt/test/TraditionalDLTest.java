package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.Cricketer;

public class TraditionalDLTest {

	public static void main(String[] args) {
		
		//create extra IOC Container
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Spring bean
		Cricketer cricketer = ctx.getBean("cricketer",Cricketer.class);
		//use obj to invoke methods
		cricketer.bowling();
		cricketer.fielding();
		cricketer.batting();
		
		//close Container
		((AbstractApplicationContext) ctx).close();

	}

}
