package com.nt.test;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.IBankService;

public class AspectJAOPAroundAdviceTest {

	public static void main(String[] args) {
		
		//create IOC Container
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Proxy class obj
		IBankService proxy = ctx.getBean("service", IBankService.class);
		System.out.println(proxy.getClass()+" "+proxy.getClass().getSuperclass()+" "+Arrays.toString(proxy.getClass().getInterfaces()));
		//invoke b.methods
		System.out.println(proxy.calSimpleInterest(20000, 10, 12));
		System.out.println("----------------------------------");
		System.out.println(proxy.calSimpleInterest(20000, 10, 12));
		System.out.println("=====================");
		System.out.println(proxy.calCompoundInterest(20000, 10, 12));
		System.out.println("----------------------------------");
		System.out.println(proxy.calCompoundInterest(20000, 10, 12));
		
		//close container
		((AbstractApplicationContext) ctx).close();

	}

}
