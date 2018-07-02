package com.hc.bankTransfor;

public class BankImpl implements Bank{

	@Override
	public void transfer(String from, String to, int money) {
		System.out.println(from+" transfer "+money+" dollers to "+to);
	}

}
