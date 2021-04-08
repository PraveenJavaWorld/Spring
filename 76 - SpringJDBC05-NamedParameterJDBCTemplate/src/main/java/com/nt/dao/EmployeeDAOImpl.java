package com.nt.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.model.EmployeeInfo;

@Repository("empDAO")
public class EmployeeDAOImpl implements IEmployeeDAO {
	
	private static final String GET_EMP_BY_ID = "SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE EMPNO=:id";
	
	@Autowired
	private NamedParameterJdbcTemplate npjt;

	@Override
	public EmployeeInfo getEmployeeById(int eid) {
		EmployeeInfo einfo = npjt.queryForObject(GET_EMP_BY_ID,
												Map.of("id",eid),
												(rs,rowNum)->{
													//copy RS object to Model class obj
													EmployeeInfo info = new EmployeeInfo();
													info.setEmpNo(rs.getInt(1));
													info.setEName(rs.getString(2));
													info.setJob(rs.getString(3));
													info.setSal(rs.getFloat(4));
													return info;
												});
		return einfo;
	}

	
	
	

}
