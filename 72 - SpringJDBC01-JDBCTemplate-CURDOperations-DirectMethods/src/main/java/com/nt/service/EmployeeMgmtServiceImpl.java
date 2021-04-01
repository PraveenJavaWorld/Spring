package com.nt.service;

import com.nt.dao.IEmployeeDAO;

public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {

	private IEmployeeDAO dao;
	
	public EmployeeMgmtServiceImpl(IEmployeeDAO dao) {
		System.out.println("EmployeeMgmtServiceImpl::1-Param constructor");
		this.dao = dao;
	}
	
	@Override
	public int fetchEmployeeCount() {
		int count = dao.getEmployeesCount();
		return count;
	}

}
