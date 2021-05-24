package com.nt.service;

import com.nt.dao.IBankAccountDAO;

public class BankAccountMgmtServiceImpl implements IBankAccountMgmtService {
	
	private IBankAccountDAO dao;
	
	public BankAccountMgmtServiceImpl(IBankAccountDAO dao) {
		this.dao = dao;
	}

	@Override
	public String transferMoney(int sourceAccno, int destAccno, double amount) {
		//use dao
		int count1 = dao.withdraw(sourceAccno, amount);
		int count2 = dao.deposit(destAccno, amount);
		if(count1==0 || count2==0)
			throw new RuntimeException("Transaction RollBacked-->Money is Not Transferred");
		else
			return "Transaction Succeed and Amount is Transferred";
	}

}
