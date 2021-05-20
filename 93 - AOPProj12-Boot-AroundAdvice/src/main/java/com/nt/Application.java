package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.service.BankService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
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
		((ConfigurableApplicationContext) ctx).close();
	}

}
