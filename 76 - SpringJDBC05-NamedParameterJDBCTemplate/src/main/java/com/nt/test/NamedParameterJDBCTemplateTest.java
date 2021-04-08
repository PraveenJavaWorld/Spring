package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.model.EmployeeInfo;
import com.nt.service.IEmployeeMgmtService;

public class NamedParameterJDBCTemplateTest {

	public static void main(String[] args) {
		
		//create IOC container
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Spring Bean Class Obj
		IEmployeeMgmtService service = ctx.getBean("service", IEmployeeMgmtService.class);
		
		try {
			//call b.method
			EmployeeInfo info = service.fetchEmployeeById(2);
			System.out.println(info);
			
		}catch (DataAccessException dae) {
			dae.printStackTrace();
		}

	}

}
