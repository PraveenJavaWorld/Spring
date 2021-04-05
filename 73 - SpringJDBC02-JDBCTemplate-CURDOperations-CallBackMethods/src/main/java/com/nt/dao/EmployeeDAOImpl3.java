package com.nt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;

@Repository("empDAO3")
@Primary
public class EmployeeDAOImpl3 implements IEmployeeDAO {
	
	private static final String GET_EMPLOYEE_BY_EMPNO = "SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE EMPNO=?";
	
	@Autowired
	private JdbcTemplate jt;

	//using BeanPropertyRowMapper class
	@Override
	public EmployeeBO getEmployeeByEno(int eno) {
		EmployeeBO ebo = jt.queryForObject(GET_EMPLOYEE_BY_EMPNO,new BeanPropertyRowMapper<EmployeeBO>(EmployeeBO.class),eno);
		return ebo;
	}
	
	

}//dao class
