package com.nt.beans;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MobileProduct extends Product{
	
	private int ram;
	private int storage;

}
