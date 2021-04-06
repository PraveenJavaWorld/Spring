package com.nt.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;

//@Repository("empDAO")
public class EmployeeDAOImpl2 implements IEmployeeDAO {
	
	private static final String GET_EMPLOYEES_BY_DESGS = "SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN(?,?,?)";
	
	@Autowired
	private JdbcTemplate jt;

	//using LAMBDA Expression Based Anonymous Inner Class
	@Override
	public List<EmployeeBO> getEmployeeByDesgs(String desg1, String desg2, String desg3) {
		List<EmployeeBO> listBO1 = jt.query(GET_EMPLOYEES_BY_DESGS, rs-> {
																List<EmployeeBO> listBO = new ArrayList<EmployeeBO>();
																//Copy RS Obj to BO Obj
																while(rs.next()) {
																	EmployeeBO bo = new EmployeeBO();
																	bo.setEmpno(rs.getInt(1));
																	bo.setEname(rs.getString(2));
																	bo.setJob(rs.getString(3));
																	bo.setSal(rs.getFloat(4));
																	//add each bo to listBO
																	listBO.add(bo);
																}
																return listBO;

																} , desg1,desg2,desg3);
		
		return listBO1;
	}
	
	

}//dao class
