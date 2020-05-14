package com.nineleaps.model.aop.model;

public class Circle {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("Circle's Setter setName(String name) method called."); // called 2 times - 1. spring instatiate and other one called for Aspect call
		
		throw(new RuntimeException("Exeption thrown from Circle class setName method"));
	} 

	public String setNameAndRetrun(String name) {
		this.name = name;
		System.out.println("Circle's Setter setNameAndRetrun(String name) method called."); // called 2 times - 1. spring instatiate and other one called for Aspect call
		
		return name;
	} 

}
