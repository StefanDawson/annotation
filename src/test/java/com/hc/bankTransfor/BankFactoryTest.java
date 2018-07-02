package com.hc.bankTransfor;


import org.junit.Test;

import com.hc.annotation.BankInfo;
import com.hc.test.B;


public class BankFactoryTest {

	@Test
	public void testGetBank() {
		Bank bank = BankFactory.getBank();
		bank.transfer("Stefan", "Alice", 50000000);
	}
	
	@Test
	public void test(){
		Class<?> c = B.class;
//		BankInfo a = (BankInfo) as[0];
		BankInfo b = c.getAnnotation(BankInfo.class);
		int aaa = b.maxMoney();
		System.out.println(aaa);
	}

}
