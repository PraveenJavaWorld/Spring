package com.nt.service;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public interface IEmployeeMgmtService {
	
	//Select Operations
	public int fetchEmployeeCount();
	public float fetchEmployeeSalaryByEno(int eno);
	public Map<String,Object> fetchEmployeeDetailsByEno(int eno);
	public List<Map<String,Object>> fetchEmployeeDetailsByDesignation(String desg1,String desg2,String desg3);
	public SqlRowSet fetchEmployeeDetailsBySalaryRange(float startSalary,float endSalary);

	//Insert Operations
	public String registerEmployee(String ename,String job,float salary);
	public String hikeEmployeeSalary(int eno,float percentage);
	public String fireEmployeeBySalaryRange(float startSalary,float endSalary);
	
}
