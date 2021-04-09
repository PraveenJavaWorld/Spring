package com.nt.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class CustomerDTO implements Serializable {
	
	private String cname;
	private String address;
	private float pAmt;
	private float rate;
	private float time;
	


}
