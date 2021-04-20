package com.nt.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class EmployeeInfo {
	
	private Integer empno;
	@NonNull
	private String ename;
	@NonNull
	private String job;
	@NonNull
	private Float sal;

}
