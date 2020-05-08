package com.nineleaps.model.methodinjection;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SimCardCountrySingletonAppContextAware implements ApplicationContextAware{

	private String simCountryName;

	//inject prototype object into singleton object
	private SimCardStatePrototype cardStatePrototype;
	
	private ApplicationContext applicationContext;
	
	public SimCardCountrySingletonAppContextAware() {
		System.out.println("Singleton Bean Instantiated - SimCardCountrySingletonAppContextAware!!");
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
	
	public SimCardStatePrototype getSimCardStatePrototype()
	{
		cardStatePrototype = (SimCardStatePrototype) applicationContext.getBean("simCardStateAware");
		
		return cardStatePrototype;
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
	
}
