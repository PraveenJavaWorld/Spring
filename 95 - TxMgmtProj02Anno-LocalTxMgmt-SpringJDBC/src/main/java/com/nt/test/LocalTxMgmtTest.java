package com.nt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.IBankAccountMgmtService;

public class LocalTxMgmtTest {

	public static void main(String[] args) {
		
		//create IOC Container
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
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
