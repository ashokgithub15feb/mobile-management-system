package com.nineleaps.model;

public class PhoneNumber {

	private String number;

	private String name;
	
	public PhoneNumber(String number, String name) {
		this.number = number;
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public PhoneNumber() {
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "PhoneNumber [" + number + ", name=" + name + "]";
	}
	
	
}
