package com.nineleaps.model.methodinjection;

/*
   We need to create an abstract method in Singleton class with return type as  PrototypeBean .
   Prototype bean class will declare one method which returns the current instance (this).
  
   <lookup-method bean="prototypeBean" name="getPrototypeBean"/>
   
   This tag specifies that dependency will be resolved by calling method of a bean and since the bean is 
   of type prototype, we will get new instance on every call.
   
 */


public abstract class SimCardCountrySingletonAbstract {

	private String simCountryName;

	//inject prototype object into singleton object
	public abstract SimCardStatePrototypeAbstractClassDependent getSimCardStatePrototypeAbstractClassDependent();
	
	public SimCardCountrySingletonAbstract() {
		System.out.println("Singleton Bean Instantiated - Method Injection Using Lookup tag!!");
	}

	public String getSimCountryName() {
		return simCountryName;
	}

	public void setSimCountryName(String simCountryName) {
		this.simCountryName = simCountryName;
	}
	
}
