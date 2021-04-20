package com.nt.dao;

import java.util.List;

import com.nt.model.EmployeeInfo;

public interface IEmployeeDAO {
	
	//Select Operations
	public EmployeeInfo getEmployeeById(int id);
	public List<EmployeeInfo> getEmployeesByJob(String job1,String job2,String job3);

}
