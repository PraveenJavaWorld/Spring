package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nt.dto.CustomerDTO;
import com.nt.service.ICustomerMgmtService;
import com.nt.vo.CustomerVO;

@Controller("controller")
public class BankController {
	
	@Autowired
	private ICustomerMgmtService service;
	
	public BankController() {
		System.out.println("BankController::0-param constructor");
	}
	
	public String processCustomer(CustomerVO vo) throws Exception{
		//convert CustomerVO to Customer DTO
		CustomerDTO dto = new CustomerDTO();
		dto.setCname(vo.getCname());
		dto.setAddress(vo.getAddress());
		dto.setPAmt(Float.parseFloat(vo.getPAmt()));
		dto.setRate(Float.parseFloat(vo.getRate()));
		dto.setTime(Float.parseFloat(vo.getTime()));
		
		//use service
		String result = service.calculateSimpleInterestAmount(dto);
		
		return result;
	}
	

}
