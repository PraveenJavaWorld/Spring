package com.nt.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.config.AppConfig;
import com.nt.dto.EmployeeDTO;
import com.nt.service.IEmployeeMgmtService;

public class CallBackMethodsTest {

	public static void main(String[] args) {
		
		//create IOC Container
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		//get Spring bean class obj
		IEmployeeMgmtService service = ctx.getBean("service", IEmployeeMgmtService.class);
		//invoke b.method
		try {
			System.out.println("Employees are :: ");
			List<EmployeeDTO> listDTO = service.fetchEmployeeByDesgs("SALESMAN", "DEVELOPER", "MANAGER");
			listDTO.forEach(System.out::println);
		}
		catch (DataAccessException dae) {
			dae.printStackTrace();
		}
		
		//close IOC Container
		((AbstractApplicationContext) ctx).close();

	}

}
