package com.nt.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.EmployeeBO;
import com.nt.dao.IEmployeeDAO;
import com.nt.dto.EmployeeDTO;

@Service("service")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	
	@Autowired
	private IEmployeeDAO dao;

	@Override
	public EmployeeDTO fetchEmployeeByEno(int eno) {
		//use dao
		EmployeeBO bo = dao.getEmployeeByEno(eno);
		//convert BO to DTO
		EmployeeDTO dto = new EmployeeDTO();
		BeanUtils.copyProperties(bo, dto);
		return dto;
	}

}
