package com.nt.dao;

public interface IBankAccountDAO {
	
	public int withdraw(int accno,double amount);
	public int deposit(int accno,double amount);

}
