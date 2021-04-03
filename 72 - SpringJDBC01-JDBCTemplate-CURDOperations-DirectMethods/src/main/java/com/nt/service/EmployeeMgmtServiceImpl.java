package com.nt.service;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.nt.dao.IEmployeeDAO;

public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {

	private IEmployeeDAO dao;
	
	public EmployeeMgmtServiceImpl(IEmployeeDAO dao) {
		System.out.println("EmployeeMgmtServiceImpl::1-Param constructor");
		this.dao = dao;
	}
	
	//Select Operations
	
	@Override
	public int fetchEmployeeCount() {
		//use dao
		int count = dao.getEmployeesCount();
		return count;
	}
	
	@Override
	public float fetchEmployeeSalaryByEno(int eno) {
		//use dao
		float count = dao.getEmployeeSalaryByEno(eno);
		return count;
	}
	
	@Override
	public Map<String, Object> fetchEmployeeDetailsByEno(int eno) {
		//use dao
		Map<String,Object> map = dao.getEmployeeDetailsByEno(eno);
		return map;
	}
	
	@Override
	public List<Map<String, Object>> fetchEmployeeDetailsByDesignation(String desg1, String desg2, String desg3) {
		//use dao
		List<Map<String,Object>> list = dao.getEmployeeDetailsByDesignation(desg1, desg2, desg3);
		return list;
	}
	
	@Override
	public SqlRowSet fetchEmployeeDetailsBySalaryRange(float startSalary, float endSalary) {
		//use dao
		SqlRowSet rowset = dao.getEmployeeDetailsBySalaryRange(startSalary, endSalary); 
		return rowset;
	}
	
	//Insert Operations
	
	@Override
	public String registerEmployee(String ename, String job, float salary) {
		//use dao
		int count = dao.insertEmployee(ename, job, salary);
		return count==0?"Employee Not Registered":"Employee Registered";
	}
	
	@Override
	public String hikeEmployeeSalary(int eno, float percentage) {
		//get current salary
		float salary = dao.getEmployeeSalaryByEno(eno);
		//calculate new salary
		float newSalary = salary+(salary*percentage/100.0f);
		//use dao
		int count = dao.updateEmployeeSalary(eno, newSalary);
		return count==0?"Salary Not Updated":"Salary Updated";
	}
	
	@Override
	public String fireEmployeeBySalaryRange(float startSalary, float endSalary) {
		//use dao
		int count = dao.deleteEmployeeBySalaryRange(startSalary, endSalary);
		return count==0?"No Employees are Deleted":count+ " Employees are Deleted";
	}

}
