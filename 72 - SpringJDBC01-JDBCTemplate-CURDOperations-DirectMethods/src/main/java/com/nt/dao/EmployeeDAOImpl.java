package com.nt.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class EmployeeDAOImpl implements IEmployeeDAO {

	//Select Operations Queries
	private static final String GET_EMPS_COUNT = "SELECT COUNT(*) FROM EMP";
	private static final String GET_EMPS_SALARY_BY_EMPNO = "SELECT SAL FROM EMP WHERE EMPNO=?";
	private static final String GET_EMPS_DETAILS_BY_EMPNO = "SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE EMPNO=?";
	private static final String GET_EMPS_DETAILS_BY_DESGS = "SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN(?,?,?) ORDER BY JOB";
	private static final String GET_EMPS_DETAILS_BY_SALRANGE = "SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE SAL>=? AND SAL<=?";
	
	//Insert Operations Queries
	private static final String INSERT_EMP_QUERY = "INSERT INTO EMP(EMPNO,ENAME,JOB,SAL) VALUES(EMPNO_SEQ.NEXTVAL,?,?,?)";
	private static final String UPDATE_EMP_SALARY = "UPDATE EMP SET SAL=? WHERE EMPNO=?";
	private static final String DELETE_EMP_BY_SALRANGE = "DELETE FROM EMP WHERE SAL>=? AND SAL<=?";
	
	private JdbcTemplate jt;
	
	public EmployeeDAOImpl(JdbcTemplate jt) {
		System.out.println("EmployeeDAOImpl::1-Param constructor");
		this.jt = jt;
	}
	
	//Select Operations
	
	@Override
	public int getEmployeesCount() {
		int count = jt.queryForObject(GET_EMPS_COUNT, Integer.class);
		return count;
	}

	@Override
	public float getEmployeeSalaryByEno(int eno) {
		float count = jt.queryForObject(GET_EMPS_SALARY_BY_EMPNO, Float.class,eno);
		return count;
	}
	
	@Override
	public Map<String, Object> getEmployeeDetailsByEno(int eno) {
		Map<String,Object> map = jt.queryForMap(GET_EMPS_DETAILS_BY_EMPNO,eno);
		return map;
	}
	
	@Override
	public List<Map<String, Object>> getEmployeeDetailsByDesignation(String desg1, String desg2, String desg3) {
		List<Map<String,Object>> list = jt.queryForList(GET_EMPS_DETAILS_BY_DESGS,desg1,desg2,desg3);
		return list;
	}
	
	@Override
	public SqlRowSet getEmployeeDetailsBySalaryRange(float startSalary, float endSalary) {
		SqlRowSet rowset = jt.queryForRowSet(GET_EMPS_DETAILS_BY_SALRANGE, startSalary,endSalary);
		return rowset;
	}
	
	//Insert Operations
	
	@Override
	public int insertEmployee(String ename, String job, float salary) {
		int count = jt.update(INSERT_EMP_QUERY,ename,job,salary);
		return count;
	}
	
	@Override
	public int updateEmployeeSalary(int eno, float newSalary) {
		int count = jt.update(UPDATE_EMP_SALARY,newSalary,eno);
		return count;
	}
	
	@Override
	public int deleteEmployeeBySalaryRange(float startSalary, float endSalary) {
		int count = jt.update(DELETE_EMP_BY_SALRANGE,startSalary,endSalary);
		return count;
	}

}
