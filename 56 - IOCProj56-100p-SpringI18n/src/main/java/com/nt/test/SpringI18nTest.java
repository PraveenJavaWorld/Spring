package com.nt.test;

import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.nt.config.AppConfig;

public class SpringI18nTest {

	public static void main(String[] args) {

		// create IOC container
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		// create Locale Obj
		Locale locale = new Locale(args[0], args[1]);
		// get messages
		String msg1 = ctx.getMessage("wishMsg", new Object[] {}, "msg1", locale);
		String msg2 = ctx.getMessage("welcome.msg", new Object[] {}, "msg2", locale);
		String msg3 = ctx.getMessage("bye.msg", new Object[] {}, "msg3", locale);

		System.out.println(msg1 + " " + msg2 + " " + msg3);

		// close container
		((AbstractApplicationContext) ctx).close();

	}

}
