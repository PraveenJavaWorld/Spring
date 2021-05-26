package com.nt.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.config.AppConfig;
import com.nt.service.IBankAccountMgmtService;

public class LocalTxMgmtTest {

	public static void main(String[] args) {
		
		//create IOC Container
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		//get Service class obj
		IBankAccountMgmtService proxy = ctx.getBean("service",IBankAccountMgmtService.class);
		//call b.method
		try {
			System.out.println(proxy.transferMoney(1001, 1002, 5000));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		//close Container
		ctx.close();

	}

}
