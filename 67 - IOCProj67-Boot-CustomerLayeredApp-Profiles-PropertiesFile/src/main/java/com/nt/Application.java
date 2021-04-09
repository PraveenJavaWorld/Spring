package com.nt;

import java.util.Arrays;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.nt.controller.BankController;
import com.nt.vo.CustomerVO;

@SpringBootApplication
public class Application {
	
	@Autowired
	private Environment env;
	
	@Bean
	@Profile("uat")
	public DataSource createDS() throws Exception {
		ComboPooledDataSource ds = new ComboPooledDataSource();
		ds.setDriverClass(env.getRequiredProperty("spring.datasource.driver-class-name"));
		ds.setJdbcUrl(env.getRequiredProperty("spring.datasource.url"));
		ds.setUser(env.getRequiredProperty("spring.datasource.username"));
		ds.setPassword(env.getRequiredProperty("spring.datasource.password"));
		return ds;
	}

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		
		try {
			//get Spring bean class obj
			BankController controller = ctx.getBean("controller",BankController.class);
			//prepare VO obj
			CustomerVO vo = new CustomerVO();
			vo.setCname("PRAVEEN");
			vo.setAddress("HYD");
			vo.setPAmt("500000");
			vo.setRate("10");
			vo.setTime("12");
			
			//invoke b.method
			String result = controller.processCustomer(vo);
			System.out.println("Interest Amount is :: "+result);
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Activated Profile is :: "+Arrays.toString(ctx.getEnvironment().getActiveProfiles()));
		//close container
		((ConfigurableApplicationContext) ctx).close();
	}

}
