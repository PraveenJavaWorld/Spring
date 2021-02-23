package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nt.bo.CustomerBO;
import com.nt.dao.ICustomerDAO;
import com.nt.dto.CustomerDTO;

@Service("service")
public final class CustomerMgmtServiceImpl implements ICustomerMgmtService {

	@Autowired
	@Qualifier("Oracle")
	private ICustomerDAO dao;

	@Override
	public String calculateSimpleInterestAmount(CustomerDTO dto) throws Exception {
		
		//write b.logic to calculate simple interest
		
		float intAmt = (dto.getPAmt()*dto.getRate()*dto.getTime())/100.0f;
		
		//prepare CustomerBO object having persistable data
		
		CustomerBO bo = new CustomerBO();
		bo.setCname(dto.getCname());
		bo.setAddress(dto.getAddress());
		bo.setPAmt(dto.getPAmt());
		bo.setRate(dto.getRate());
		bo.setTime(dto.getTime());
		bo.setIntAmt(intAmt);
		
		//use dao
		int result = dao.insert(bo);
		//immediate if or ternary operator <condition>?<success>:<failure>
		return result==0?"Customer Registration Failed":"Customer Registration Succeed";
	}

}
