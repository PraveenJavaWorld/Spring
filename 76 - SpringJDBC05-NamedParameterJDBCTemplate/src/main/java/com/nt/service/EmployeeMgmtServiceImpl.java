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
	public EmployeeInfo fetchEmployeeById(int eid) {
		EmployeeInfo info = dao.getEmployeeById(eid);
		return info;
	}

	@Override
	public List<EmployeeInfo> fetchEmployeeByJob(String job1, String job2, String job3) {
		List<EmployeeInfo> info = dao.getEmployeeByJob(job1, job2, job3);
		return info;
	}

	@Override
	public String addEmployee(EmployeeInfo info) {
		int count = dao.insertEmployee(info);
		return count==0?"Employee Not Registered":"Employee Registered";
	}

}
