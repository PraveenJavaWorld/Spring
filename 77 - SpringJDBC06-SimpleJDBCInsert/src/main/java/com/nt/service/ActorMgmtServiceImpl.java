package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.IActorDAO;
import com.nt.model.ActorDetails;

@Service("service")
public class ActorMgmtServiceImpl implements IActorMgmtService {

	@Autowired
	private IActorDAO dao;
	
	@Override
	public String addActor(ActorDetails info) {
		int count = dao.insertActor(info);
		return count==0?"Registation Failed":"Registration Successfull";
	}

}
