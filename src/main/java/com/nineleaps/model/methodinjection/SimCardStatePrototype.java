package com.nineleaps.model.methodinjection;

/*
    Run the program and we can see that getPrototypeBean() returned same object both time

	If we need to have a different prototype bean instance every time than we have got two approaches

	1. Method Injection
	2. Use of ApplicationContextAware interface

 */
public class SimCardStatePrototype {

	private String simCardType;
	
	private String simStateName;
	
	public SimCardStatePrototype() {
		System.out.println("Prototype Bean Instantiated !!");
	}
	
	public String getSimStateName() {
		return simStateName;
	}

	public void setSimStateName(String simStateName) {
		this.simStateName = simStateName;
	}
	
	public String getSimCardType() {
		return simCardType;
	}

	public void setSimCardType(String simCardType) {
		this.simCardType = simCardType;
	}

	@Override
	public String toString() {
		return "SimCardStatePrototype [simCardType=" + simCardType + ", simStateName=" + simStateName + "]";
	}
	
}
