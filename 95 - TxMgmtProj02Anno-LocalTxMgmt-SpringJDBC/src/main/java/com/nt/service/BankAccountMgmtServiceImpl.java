package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.dao.IBankAccountDAO;

@Service("service")
public class BankAccountMgmtServiceImpl implements IBankAccountMgmtService {
	
	@Autowired
	private IBankAccountDAO dao;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = IllegalAccessException.class)
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
