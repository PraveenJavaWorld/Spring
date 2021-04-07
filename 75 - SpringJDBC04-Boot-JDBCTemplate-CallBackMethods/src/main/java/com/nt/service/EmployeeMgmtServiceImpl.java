package com.nt.service;

import java.util.ArrayList;
import java.util.List;

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
	public List<EmployeeDTO> fetchEmployeeByDesgs(String desg1, String desg2, String desg3) {
		//use dao
		List<EmployeeBO> listBO = dao.getEmployeeByDesgs(desg1, desg2, desg3);
		//convert listBO to listDTO
		List<EmployeeDTO> listDTO = new ArrayList<EmployeeDTO>();
		//convert bo to dto
		listBO.forEach(bo->{
			EmployeeDTO dto = new EmployeeDTO();
			BeanUtils.copyProperties(bo, dto);
			listDTO.add(dto);
		});
		
		return listDTO;
	}//method

}
