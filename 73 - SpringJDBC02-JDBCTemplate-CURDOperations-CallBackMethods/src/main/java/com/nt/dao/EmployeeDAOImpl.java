package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;
import com.nt.dao.IEmployeeDAO;

@Repository("empDAO")
public class EmployeeDAOImpl implements IEmployeeDAO {
	
	private static final String GET_EMPLOYEE_BY_EMPNO = "SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE EMPNO=?";
	
	@Autowired
	private JdbcTemplate jt;

	@Override
	public EmployeeBO getEmployeeByEno(int eno) {
		EmployeeBO bo = jt.queryForObject(GET_EMPLOYEE_BY_EMPNO, new EmployeeRowMapper(),eno);
		return bo;
	}
	
	//nested class (static inner class)
	private static class EmployeeRowMapper implements RowMapper<EmployeeBO>{

		@Override
		public EmployeeBO mapRow(ResultSet rs, int rowNum) throws SQLException {
			//convert rs obj to bo obj
			EmployeeBO bo = new EmployeeBO();
			bo.setEmpno(rs.getInt(1));
			bo.setEname(rs.getString(2));
			bo.setJob(rs.getString(3));
			bo.setSal(rs.getFloat(4));
			return bo;
		}//mapRow(-,-)
		
	}//inner class

}//dao class
