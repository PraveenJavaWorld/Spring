package com.nt.dao;

import java.util.List;

import com.nt.model.EmployeeInfo;

public interface IEmployeeDAO {
	
	//Select Operations
	public EmployeeInfo getEmployeeById(int eid);
	public List<EmployeeInfo> getEmployeeByJob(String job1,String job2,String job3);
	
	//Insert Operations
	public int insertEmployee(EmployeeInfo info);

}
