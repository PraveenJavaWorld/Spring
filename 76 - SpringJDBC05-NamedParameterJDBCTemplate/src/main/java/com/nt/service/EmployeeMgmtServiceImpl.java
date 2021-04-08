package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.IEmployeeDAO;
import com.nt.model.EmployeeInfo;

@Service("service")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {

	@Autowired
	private IEmployeeDAO dao;
	
	@Override
	public EmployeeInfo fetchEmployeeById(int eid) {
		EmployeeInfo info = dao.getEmployeeById(eid);
		return info;
	}

}
