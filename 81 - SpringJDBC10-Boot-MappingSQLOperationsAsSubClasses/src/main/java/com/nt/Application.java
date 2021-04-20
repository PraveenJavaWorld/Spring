package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.model.EmployeeInfo;
import com.nt.service.IEmployeeMgmtService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		//get service class obj
		IEmployeeMgmtService service = ctx.getBean("service", IEmployeeMgmtService.class);
				
			try {
				EmployeeInfo info = service.fetchEmployeeById(2);
				if(info!=null)
					System.out.println("Employee Details are :: "+info);
				else
					System.out.println("Employee Not Found");
			}
			catch (DataAccessException dae) {
				dae.printStackTrace();
			}
	}

}
