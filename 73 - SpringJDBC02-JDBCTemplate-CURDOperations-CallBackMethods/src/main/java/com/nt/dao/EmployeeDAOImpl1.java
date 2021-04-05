package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;

//@Repository("empDAO1")
//@Primary
public class EmployeeDAOImpl1 implements IEmployeeDAO {
	
	private static final String GET_EMPLOYEE_BY_EMPNO = "SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE EMPNO=?";
	
	@Autowired
	private JdbcTemplate jt;

	//using Anonymous Inner Class
	@Override
	public EmployeeBO getEmployeeByEno(int eno) {
		EmployeeBO bo = jt.queryForObject(GET_EMPLOYEE_BY_EMPNO, new RowMapper<EmployeeBO>() {
			                                                @Override
			                                                public EmployeeBO mapRow(ResultSet rs, int rowNum) throws SQLException {
			                                                	//Copy RS Obj to BO Obj
			                                                	EmployeeBO bo = new EmployeeBO();
			                                                	bo.setEmpno(rs.getInt(1));
			                                                	bo.setEname(rs.getString(2));
			                                                	bo.setJob(rs.getString(3));
			                                                	bo.setSal(rs.getFloat(4));
			                                                	return bo;
			                                                }
		                                                         }
		                                                         ,eno);
		return bo;
	}
	
	

}//dao class
