package com.nt.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public interface IEmployeeDAO {
	//Select Operations
	public int getEmployeesCount();
	public float getEmployeeSalaryByEno(int eno);
	public Map<String,Object> getEmployeeDetailsByEno(int eno);
	public List<Map<String,Object>> getEmployeeDetailsByDesignation(String desg1,String desg2,String desg3);
	public SqlRowSet getEmployeeDetailsBySalaryRange(float startSalary,float endSalary);
	
	//Insert Operations
	public int insertEmployee(String ename,String job,float salary);
	public int updateEmployeeSalary(int eno,float newSalary);
	public int deleteEmployeeBySalaryRange(float startSalary,float endSalary);

}
