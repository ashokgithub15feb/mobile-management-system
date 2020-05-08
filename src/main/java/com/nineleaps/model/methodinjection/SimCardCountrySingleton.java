package com.nineleaps.model.methodinjection;

// Method Injection should be used is when a Singleton bean has a dependency on Prototype bean.
// Singleton: Instantiate only one object
// Prototype: Instantiate a new object every time.
// Spring container resolves the dependencies at instantiation time which means if any singleton bean has  
// a dependency of any prototype bean, then a new object of prototype bean will be instantiated and injected in 
// to singleton bean at the time of instantiation of Singleton bean.

//Note: With this, the same prototype bean will always supplied from singleton bean.

//Method Injection approach dependencies are resolved using method look ups in which specified method of given bean 
//is called to get the bean instance.


public class SimCardCountrySingleton {

	private String simCountryName;

	//inject prototype object into singleton object
	private SimCardStatePrototype cardStatePrototype;
	
	public SimCardCountrySingleton() {
		System.out.println("Singleton Bean Instantiated !!");
	}
	
	public String getSimCountryName() {
		return simCountryName;
	}

	public void setSimCountryName(String simCountryName) {
		this.simCountryName = simCountryName;
	}

	public SimCardStatePrototype getCardStatePrototype() {
		return cardStatePrototype;
	}

	public void setCardStatePrototype(SimCardStatePrototype cardStatePrototype) {
		this.cardStatePrototype = cardStatePrototype;
	}

	@Override
	public String toString() {
		return "SimCardCountrySingleton [simCountryName=" + simCountryName + ", cardStatePrototype="
				+ cardStatePrototype + "]";
	}
	
}
