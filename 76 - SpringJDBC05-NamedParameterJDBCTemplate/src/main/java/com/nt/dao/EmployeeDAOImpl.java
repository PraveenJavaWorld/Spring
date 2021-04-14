package com.nt.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.model.EmployeeInfo;

@Repository("empDAO")
public class EmployeeDAOImpl implements IEmployeeDAO {
	
	private static final String GET_EMP_BY_ID = "SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE EMPNO=:id";
	private static final String GET_EMPS_BY_JOB = "SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN(:job1,:job2,:job3)";
	private static final String INSERT_EMP_INFO_QUERY = "INSERT INTO EMP(EMPNO,ENAME,JOB,SAL) VALUES(EMPNO_SEQ.NEXTVAL,:eName,:job,:sal)";
	
	@Autowired
	private NamedParameterJdbcTemplate npjt;
	
	//Select Operations
	
	/*@Override
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
	}*/
	
	@Override
	public EmployeeInfo getEmployeeById(int eid) {
		EmployeeInfo einfo = npjt.queryForObject(GET_EMP_BY_ID,
												Map.of("id",eid),
												new BeanPropertyRowMapper<EmployeeInfo>(EmployeeInfo.class));
		return einfo;
	}


	/*@Override
	public List<EmployeeInfo> getEmployeeByJob(String job1, String job2, String job3) {
		MapSqlParameterSource source = new MapSqlParameterSource();
		source.addValue("job1", job1);
		source.addValue("job2", job2);
		source.addValue("job3", job3);
		List<EmployeeInfo> list = npjt.query(GET_EMPS_BY_JOB, source,
											rs->{
												List<EmployeeInfo> listInfo = new ArrayList<EmployeeInfo>();
												while(rs.next()) {
													EmployeeInfo einfo = new EmployeeInfo();
													einfo.setEmpNo(rs.getInt(1));
													einfo.setEName(rs.getString(2));
													einfo.setJob(rs.getString(3));
													einfo.setSal(rs.getFloat(4));
													listInfo.add(einfo);
												}//while
												return listInfo;
											});
		return list;
	}*/


	@Override
	public List<EmployeeInfo> getEmployeeByJob(String job1, String job2, String job3) {
		MapSqlParameterSource source = new MapSqlParameterSource();
		source.addValue("job1", job1);
		source.addValue("job2", job2);
		source.addValue("job3", job3);
		List<EmployeeInfo> info  = npjt.query(GET_EMPS_BY_JOB, source, new RowMapperResultSetExtractor<EmployeeInfo>(new BeanPropertyRowMapper<EmployeeInfo>(EmployeeInfo.class)));
		return info;
	}


	//Insert Operations
	
	@Override
	public int insertEmployee(EmployeeInfo info) {
		BeanPropertySqlParameterSource bpsps = new BeanPropertySqlParameterSource(info);
		int count = npjt.update(INSERT_EMP_INFO_QUERY, bpsps);
		return count;
	}
	
	

}
