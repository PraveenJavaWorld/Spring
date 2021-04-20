package com.nt.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.model.EmployeeInfo;
import com.nt.service.IEmployeeMgmtService;

public class MappingSQLOperationsTest {

	public static void main(String[] args) {
		
		//create IOC container
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
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
		
		try {
			List<EmployeeInfo> list = service.fetchEmployeesByJob("ANALYST","DEVELOPER","SALESMAN");
			if(list!=null || list.size()>=1)
				list.forEach(System.out::println);
			else
				System.out.println("Employees Not Found");
		}
		catch (DataAccessException dae) {
			dae.printStackTrace();
		}
		
		//close container
		((AbstractApplicationContext) ctx).close();

	}

}
