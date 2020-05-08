package com.nineleaps.model;

public class Airtel implements Sim
{
	
	public Airtel() {
		System.out.println("Airtel Constructor called!!!!!");
	}
	
	@Override
	public void calling() {
		
		System.out.println("Calling using Airtel Sim");
	}

	@Override
	public void data() {
		System.out.println("Browsing internet using Airtel Sim");
	}

}
