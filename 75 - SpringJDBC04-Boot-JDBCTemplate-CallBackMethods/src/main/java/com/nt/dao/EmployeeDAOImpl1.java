package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;

//@Repository("empDAO")
public class EmployeeDAOImpl1 implements IEmployeeDAO {
	
	private static final String GET_EMPLOYEES_BY_DESGS = "SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN(?,?,?)";
	
	
	@Autowired
	private JdbcTemplate jt;

	//using Anonymous Inner Class
	@Override
	public List<EmployeeBO> getEmployeeByDesgs(String desg1, String desg2, String desg3) {
		List<EmployeeBO> listBO = jt.query(GET_EMPLOYEES_BY_DESGS, new ResultSetExtractor<List<EmployeeBO>>() {

			@Override
			public List<EmployeeBO> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<EmployeeBO> listBO = new ArrayList<EmployeeBO>();
				while(rs.next()) {
					//Copy RS Obj to BO Obj
                	EmployeeBO bo = new EmployeeBO();
                	bo.setEmpno(rs.getInt(1));
                	bo.setEname(rs.getString(2));
                	bo.setJob(rs.getString(3));
                	bo.setSal(rs.getFloat(4));
                	//add each bo to listBO
                	listBO.add(bo);
				}
				return listBO;
			}//method
		}//Anonymous Inner Class
		, desg1,desg2,desg3);
		
		return listBO;
	}
	
	

}//dao class
