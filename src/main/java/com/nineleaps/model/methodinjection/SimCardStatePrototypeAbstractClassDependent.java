package com.nineleaps.model.methodinjection;

/*
	If we need to have a different prototype bean instance every time than we have got two approaches

	1. Method Injection
	2. Use of ApplicationContextAware interface

 */
public class SimCardStatePrototypeAbstractClassDependent {

	private String simCardType;
	
	private String simStateName;
	
	public SimCardStatePrototypeAbstractClassDependent() {
		System.out.println("Prototype Bean Instantiated - Method Injection Using Lookup tag!!");
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

	public SimCardStatePrototypeAbstractClassDependent getSimCardStatePrototypeAbstractClassDependent()
	{
		return this;
	}
	
	@Override
	public String toString() {
		return "SimCardStatePrototype [simCardType=" + simCardType + ", simStateName=" + simStateName + "]";
	}
	
}
