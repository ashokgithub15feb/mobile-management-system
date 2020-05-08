package com.nineleaps.domain;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class PhoneBook implements InitializingBean, DisposableBean{

	private String phoneBookName;

	public PhoneBook() {
		System.out.println("Constructor of PhoneBook bean is called !!");
	}
	
	public String getPhoneBookName() {
		return phoneBookName;
	}

	public void setPhoneBookName(String phoneBookName) {
		this.phoneBookName = phoneBookName;
	}

	@Override
	public String toString() {
		return "PhoneBook [phoneBookName=" + phoneBookName + "]";
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Destroy method of PhoneBook bean called !! ");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet method of PhoneBook bean is called !!");
	}
	
	
}
