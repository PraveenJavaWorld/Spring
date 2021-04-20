package com.nt.service;

import java.util.List;

import com.nt.model.EmployeeInfo;

public interface IEmployeeMgmtService {
	
	//Select Operations
	public EmployeeInfo fetchEmployeeById(int id);
	public List<EmployeeInfo> fetchEmployeesByJob(String job1,String job2,String job3);
	
	//Non-Select Operations
	public String modifyEmployeeSalaryById(float sal,int id);

}
