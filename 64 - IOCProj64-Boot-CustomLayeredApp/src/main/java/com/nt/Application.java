package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.controller.BankController;
import com.nt.vo.CustomerVO;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		
		try {
			//get Spring bean class obj
			BankController controller = ctx.getBean("controller",BankController.class);
			//prepare VO obj
			CustomerVO vo = new CustomerVO();
			vo.setCname("PRAVEEN CH");
			vo.setAddress("RCPM");
			vo.setPAmt("500000");
			vo.setRate("24");
			vo.setTime("12");
			
			//invoke b.method
			String result = controller.processCustomer(vo);
			System.out.println("Interest Amount is :: "+result);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		//close container
		((ConfigurableApplicationContext) ctx).close();
		
	}

}
