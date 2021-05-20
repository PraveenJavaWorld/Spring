package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.nt.config.AppConfig;
import com.nt.service.BankService;

public class AspectJAOPAroundAdviceTest {

	public static void main(String[] args) {
		
		//create IOC Container
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		//get Proxy class obj
		BankService proxy = ctx.getBean("service", BankService.class);
		System.out.println(proxy.getClass()+" "+proxy.getClass().getSuperclass());
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
