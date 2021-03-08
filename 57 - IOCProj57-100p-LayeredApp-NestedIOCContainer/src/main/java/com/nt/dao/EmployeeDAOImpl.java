package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;

@Repository("empDao")
public class EmployeeDAOImpl implements IEmployeeDAO {
	
	private static final String GET_EMP_DESGS = "SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE JOB IN(?,?,?) ORDER BY JOB";
	
	@Autowired
	private DataSource ds;

	@Override
	public List<EmployeeBO> getEmpByDesgs(String desg1, String desg2, String desg3) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<EmployeeBO> listBO = null;
		try {
			//get Pooled JDBC con object
			con = ds.getConnection();
			//create JDBC PreparedStatement obj
			ps = con.prepareStatement(GET_EMP_DESGS);
			//set values to query params
			ps.setString(1, desg1);
			ps.setString(2, desg2);
			ps.setString(3, desg3);
			//execute the Query
			rs = ps.executeQuery();
			//convert  ResultSet obj records to ListBO
			listBO = new ArrayList();
			while(rs.next()) {
				EmployeeBO bo = new EmployeeBO();
				bo.setEmpNo(rs.getInt(1));
				bo.setEname(rs.getString(2));
				bo.setJob(rs.getString(3));
				bo.setSal(rs.getFloat(4));
				bo.setDeptNo(rs.getInt(5));
				listBO.add(bo);
			}//while
		} catch (SQLException se) {
			se.printStackTrace();
			throw se; //Exception ReThrowing
		}catch (Exception e) {
			e.printStackTrace();
			throw e; //Exception ReThrowing
		}
		finally {
			try {
				if(rs!=null)
					rs.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if(ps!=null)
					ps.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if(con!=null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}//finally
		return listBO;
	}//method

}//class
