package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;

//@Repository("empDAO")
public class EmployeeDAOImpl implements IEmployeeDAO {
	
	private static final String GET_EMPLOYEES_BY_DESGS = "SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN(?,?,?)";
	
	@Autowired
	private JdbcTemplate jt;

	@Override
	public List<EmployeeBO> getEmployeeByDesgs(String desg1, String desg2, String desg3) {
		List<EmployeeBO> listBO = jt.query(GET_EMPLOYEES_BY_DESGS,new EmployeeRSExtractor(),desg1,desg2,desg3);
		return listBO;
	}
	
	//nested class (static inner class)
	private static class EmployeeRSExtractor implements ResultSetExtractor<List<EmployeeBO>>{

		@Override
		public List<EmployeeBO> extractData(ResultSet rs) throws SQLException, DataAccessException {
			List<EmployeeBO> listBO = new ArrayList<EmployeeBO>();
			while(rs.next()) {
				//convert rs to bo
				EmployeeBO bo = new EmployeeBO();
				bo.setEmpno(rs.getInt(1));
				bo.setEname(rs.getString(2));
				bo.setJob(rs.getString(3));
				bo.setSal(rs.getFloat(4));
				//add each bo to listBO
				listBO.add(bo);
			}//while
			return listBO;
		}//method
		
	}//inner class

}//dao class
