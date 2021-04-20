package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.stereotype.Repository;

import com.nt.model.EmployeeInfo;

@Repository("empDAO")
public class EmployeeDAOImpl implements IEmployeeDAO {

	private static final String GET_EMP_BY_ID = "SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE EMPNO=?";
	private static final String GET_EMPS_BY_JOB = "SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN(?,?,?)";
	
	private EmployeeSelector1 selector1;
	private EmployeeSelector2 selector2;
	
	@Autowired
	public EmployeeDAOImpl(DataSource ds) {
		selector1 = new EmployeeSelector1(ds, GET_EMP_BY_ID);
		selector2 = new EmployeeSelector2(ds, GET_EMPS_BY_JOB);
	}
	
	@Override
	public EmployeeInfo getEmployeeById(int id) {
		EmployeeInfo info = selector1.findObject(id);
		return info;
	}
	
	@Override
	public List<EmployeeInfo> getEmployeesByJob(String job1, String job2, String job3) {
		List<EmployeeInfo> list = selector2.execute(job1,job2,job3);
		return list;
	}
	
	
	//inner class for only one record
	private static class EmployeeSelector1 extends MappingSqlQuery<EmployeeInfo>{

		public EmployeeSelector1(DataSource ds,String query) {
			
			super(ds,query);
			super.declareParameter(new SqlParameter(Types.INTEGER));
			super.compile();
			
		}
		
		@Override
		protected EmployeeInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
			EmployeeInfo info = new EmployeeInfo();
			//convert RS to Model class
			info.setEmpno(rs.getInt(1));
			info.setEname(rs.getString(2));
			info.setJob(rs.getString(3));
			info.setSal(rs.getFloat(4));
			return info;
		}
		
	}//inner class 1
	//=====================================================================================================
	//inner class for list of record
		private static class EmployeeSelector2 extends MappingSqlQuery<EmployeeInfo>{

			public EmployeeSelector2(DataSource ds,String query) {
				
				super(ds,query);
				super.declareParameter(new SqlParameter(Types.VARCHAR));
				super.declareParameter(new SqlParameter(Types.VARCHAR));
				super.declareParameter(new SqlParameter(Types.VARCHAR));
				super.compile();
				
			}
			
			@Override
			protected EmployeeInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
				EmployeeInfo info = new EmployeeInfo();
				//convert RS to Model class
				info.setEmpno(rs.getInt(1));
				info.setEname(rs.getString(2));
				info.setJob(rs.getString(3));
				info.setSal(rs.getFloat(4));
				return info;
			}
			
		}//inner class 2

	

}//class
