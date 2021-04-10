package com.nt.test;

import java.util.Arrays;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import com.nt.controller.BankController;
import com.nt.vo.CustomerVO;

public class SpringProfilesTest {

	public static void main(String[] args) {
		
		//create IOC Container
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext();
		//get Environment Obj
		ConfigurableEnvironment env = (ConfigurableEnvironment) ctx.getEnvironment();
		//specify active profile
		env.setActiveProfiles("dev");
		//specify Spring bean cfg xml file
		ctx.setConfigLocation("com/nt/cfgs/applicationContext.xml");
		ctx.refresh();
		
		try {
			//get Spring bean class obj
			BankController controller = ctx.getBean("controller",BankController.class);
			//prepare VO obj
			CustomerVO vo = new CustomerVO();
			vo.setCname("PRAVEEN");
			vo.setAddress("HYD");
			vo.setPAmt("100000");
			vo.setRate("2");
			vo.setTime("24");
			
			//invoke b.method
			String result = controller.processCustomer(vo);
			System.out.println("Interest Amount is :: "+result);
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Activated Profile is :: "+Arrays.toString(env.getActiveProfiles()));
		//close container
		((ConfigurableApplicationContext) ctx).close();

	}

}
