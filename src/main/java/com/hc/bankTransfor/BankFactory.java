package com.hc.bankTransfor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.hc.annotation.BankInfo;

public class BankFactory {
	public static Bank getBank(){
		final Bank bank = new BankImpl();
		Bank proxy = (Bank) Proxy.newProxyInstance(bank.getClass().getClassLoader(),
				bank.getClass().getInterfaces(), 
				new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) 
							throws Throwable {
						if("transfer".equals(method.getName())){
							if(! method.isAnnotationPresent(BankInfo.class)){
								return method.invoke(bank, args);
							}
							BankInfo info = method.getAnnotation(BankInfo.class);
							int maxMoney = info.maxMoney();
							int transMoney = (int) args[2];
							if(maxMoney<transMoney){
								System.out.println("Transfer failed");
								return null;
							}else{
								Object ret = method.invoke(bank, args);
								return ret;
							}
						}else{
							return method.invoke(bank, args);
						}
					}
				});
		return proxy;
	}
}
