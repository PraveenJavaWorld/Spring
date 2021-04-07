package com.nt.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;

@Repository("empDAO")
public class EmployeeDAOImpl3 implements IEmployeeDAO {
	
	private static final String GET_EMPLOYEES_BY_DESGS = "SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN(?,?,?)";
	
	@Autowired
	private JdbcTemplate jt;

	//method 1
	/*@Override
	public List<EmployeeBO> getEmployeeByDesgs(String desg1, String desg2, String desg3) {
		List<EmployeeBO> listBO = jt.query(GET_EMPLOYEES_BY_DESGS, new RowMapperResultSetExtractor<EmployeeBO>(new BeanPropertyRowMapper<EmployeeBO>(EmployeeBO.class)),desg1,desg2,desg3);
		return listBO;
	}*/
	
	//method 2
	@Override
	public List<EmployeeBO> getEmployeeByDesgs(String desg1, String desg2, String desg3) {
		BeanPropertyRowMapper<EmployeeBO> rowMapper = new BeanPropertyRowMapper<EmployeeBO>(EmployeeBO.class);
		List<EmployeeBO> listBO = jt.query(GET_EMPLOYEES_BY_DESGS, new RowMapperResultSetExtractor<EmployeeBO>(rowMapper),desg1,desg2,desg3);
		return listBO;
	}
	
	//method 3
	/*@Override
	public List<EmployeeBO> getEmployeeByDesgs(String desg1, String desg2, String desg3) {
		
		return jt.query(GET_EMPLOYEES_BY_DESGS, new RowMapperResultSetExtractor<EmployeeBO>(new BeanPropertyRowMapper<EmployeeBO>(EmployeeBO.class)),desg1,desg2,desg3);
	}*/
	
	

}//dao class
