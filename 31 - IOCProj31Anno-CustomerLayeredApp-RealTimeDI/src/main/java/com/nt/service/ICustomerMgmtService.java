package com.nt.service;

import com.nt.dto.CustomerDTO;

public interface ICustomerMgmtService {
	
	public String calculateSimpleInterestAmount(CustomerDTO dto) throws Exception;

}
