package com.nt;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.dto.EmployeeDTO;
import com.nt.service.IEmployeeMgmtService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		
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
