package com.nt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;

//@Repository("empDAO2")
//@Primary
public class EmployeeDAOImpl2 implements IEmployeeDAO {
	
	private static final String GET_EMPLOYEE_BY_EMPNO = "SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE EMPNO=?";
	
	@Autowired
	private JdbcTemplate jt;

	//using LAMBDA Expression Based Anonymous Inner Class
	@Override
	public EmployeeBO getEmployeeByEno(int eno) {
		EmployeeBO ebo = jt.queryForObject(GET_EMPLOYEE_BY_EMPNO, (rs, rowNum) -> {
			                                                	//Copy RS Obj to BO Obj
			                                                	EmployeeBO bo = new EmployeeBO();
			                                                	bo.setEmpno(rs.getInt(1));
			                                                	bo.setEname(rs.getString(2));
			                                                	bo.setJob(rs.getString(3));
			                                                	bo.setSal(rs.getFloat(4));
			                                                	return bo;
			                                                   }
		                                                         ,eno);
		return ebo;
	}
	
	

}//dao class
