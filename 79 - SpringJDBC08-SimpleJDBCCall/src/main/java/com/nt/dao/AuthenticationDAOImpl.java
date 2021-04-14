package com.nt.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

@Repository("authDAO")
public class AuthenticationDAOImpl implements IAuthenticationDAO {
	
	@Autowired
	private SimpleJdbcCall sjc;

	@Override
	public String authenticate(String username, String password) {
		//set PL/SQL Procedure name
		sjc.setProcedureName("P_AUTHENTICATION");
		//prepare Map of INParam Names and Values
		Map<String,Object> inParams = Map.of("USERNAME",username,"PASSWORD",password);
		//execute/call PL/SQL Procedure
		Map<String,Object> outParams = sjc.execute(inParams);
		//gather results
		return (String)outParams.get("RESULT");
	}

}
