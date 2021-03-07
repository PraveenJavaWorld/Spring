package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.nt.beans.WishMessageGenerator;
import com.nt.config.AppConfig;

public class InjectionTest {

	public static void main(String[] args) {
		
		//create IOC Container
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		//get spring bean obj
		WishMessageGenerator wmg = ctx.getBean("wmg",WishMessageGenerator.class);
		//invoke b.methods
		System.out.println(wmg.generateWishMessage("Praveen"));
		
		//close Container
		((AbstractApplicationContext) ctx).close();

	}

}
