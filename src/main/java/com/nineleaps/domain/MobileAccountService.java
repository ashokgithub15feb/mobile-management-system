package com.nineleaps.domain;

public class MobileAccountService {

	private String accountHolder;

	public MobileAccountService() {
	}
	
	public MobileAccountService(String accountHolder) {
		this.accountHolder = accountHolder;
	}

	public String getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}
	
}
