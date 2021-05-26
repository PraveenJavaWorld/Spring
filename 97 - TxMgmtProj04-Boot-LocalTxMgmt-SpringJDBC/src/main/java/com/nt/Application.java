package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.service.IBankAccountMgmtService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
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
		((ConfigurableApplicationContext) ctx).close();

	}

}
