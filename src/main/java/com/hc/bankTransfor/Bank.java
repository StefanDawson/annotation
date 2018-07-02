package com.hc.bankTransfor;

import com.hc.annotation.BankInfo;

public interface Bank {
	@BankInfo(maxMoney=100000000)
	public void transfer(String from,String to,int money);
}
