package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.IAuthenticationDAO;

@Service("service")
public class LoginMgmtServiceImpl implements ILoginMgmtService {

	@Autowired
	private IAuthenticationDAO dao;
	
	@Override
	public String login(String username, String password) {
		String result = dao.authenticate(username, password);
		return result;
	}

}
