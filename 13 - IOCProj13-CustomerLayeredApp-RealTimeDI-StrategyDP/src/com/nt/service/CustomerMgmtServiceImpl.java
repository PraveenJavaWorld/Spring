package com.nt.service;

import com.nt.bo.CustomerBO;
import com.nt.dao.ICustomerDAO;
import com.nt.dto.CustomerDTO;

public final class CustomerMgmtServiceImpl implements ICustomerMgmtService {

	private ICustomerDAO dao;

	public CustomerMgmtServiceImpl(ICustomerDAO dao) {
		this.dao = dao;
	}

	@Override
	public String calculateSimpleInterestAmount(CustomerDTO dto) throws Exception {
		
		//write b.logic to calculate simple interest
		
		float intAmt = (dto.getpAmt()*dto.getRate()*dto.getTime())/100.0f;
		
		//prepare CustomerBO object having persistable data
		
		CustomerBO bo = new CustomerBO();
		bo.setCname(dto.getCname());
		bo.setAddress(dto.getAddress());
		bo.setpAmt(dto.getpAmt());
		bo.setRate(dto.getRate());
		bo.setTime(dto.getTime());
		bo.setIntAmt(intAmt);
		
		//use dao
		int result = dao.insert(bo);
		//immediate if or ternary operator <condition>?<success>:<failure>
		return result==0?"Customer Registration Failed":"Customer Registration Succeed";
	}

}
