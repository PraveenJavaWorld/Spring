package com.nt.bo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeBO implements Serializable {
	
	private int empno;
	private String ename;
	private String job;
	private float sal;

}
