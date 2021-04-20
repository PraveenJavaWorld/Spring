package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.IEmployeeDAO;
import com.nt.model.EmployeeInfo;

@Service("service")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {

	@Autowired
	private IEmployeeDAO dao;
	
	//Select Operations
	
	@Override
	public EmployeeInfo fetchEmployeeById(int id) {
		//use dao
		EmployeeInfo info = dao.getEmployeeById(id);
		return info;
	}

	@Override
	public List<EmployeeInfo> fetchEmployeesByJob(String job1, String job2, String job3) {
		List<EmployeeInfo> list = dao.getEmployeesByJob(job1, job2, job3);
		return list;
	}
	
	//Non-Select Operations

	@Override
	public String modifyEmployeeSalaryById(float sal, int id) {
		int count = dao.updateEmployeeSalaryById(sal, id);
		return count==0?"Salary Not Updated":"Salary Updated";
	}

}
