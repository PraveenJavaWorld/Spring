package com.nt.dao;

import java.util.List;

import com.nt.bo.EmployeeBO;

public interface IEmployeeDAO {
	
	public List<EmployeeBO> getEmpByDesgs(String desg1,String desg2,String desg3) throws Exception;

}
