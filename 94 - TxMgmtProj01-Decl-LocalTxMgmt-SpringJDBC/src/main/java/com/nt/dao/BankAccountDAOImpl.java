package com.nt.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class BankAccountDAOImpl implements IBankAccountDAO {
	
	private JdbcTemplate jt;
	
	public BankAccountDAOImpl(JdbcTemplate jt) {
		this.jt = jt;
	}
	
	private static final String WITHDRAW_ACCOUNT = "UPDATE SPRING_TX_BANKACCOUNT SET BALANCE=BALANCE-? WHERE ACCOUNTNUMBER=?";
	private static final String DEPOSIT_ACCOUNT = "UPDATE SPRING_TX_BANKACCOUNT SET BALANCE=BALANCE+? WHERE ACCOUNTNUMBER=?";

	@Override
	public int withdraw(int accno, double amount) {
		int count1 = jt.update(WITHDRAW_ACCOUNT,amount,accno);
		return count1;
	}

	@Override
	public int deposit(int accno, double amount) {
		int count2 = jt.update(DEPOSIT_ACCOUNT,amount,accno);
		return count2;
	}
	
}
