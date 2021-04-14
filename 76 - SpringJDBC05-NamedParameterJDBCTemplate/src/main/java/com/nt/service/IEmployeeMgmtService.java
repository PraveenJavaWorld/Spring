package com.nt.service;

import java.util.List;

import com.nt.model.EmployeeInfo;

public interface IEmployeeMgmtService {
	
	//Select Operations
	public EmployeeInfo fetchEmployeeById(int eid);
	public List<EmployeeInfo> fetchEmployeeByJob(String job1,String job2,String job3);
	
	//Insert Operations
	public String addEmployee(EmployeeInfo info);

}
