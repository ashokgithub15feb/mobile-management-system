package com.nineleaps.model;

public class Vodaphone implements Sim
{

	public Vodaphone() {
		System.out.println("Vodaphone Constructor called!!!!!");
	}
	
	@Override
	public void calling() {
		
		System.out.println("Calling using Vodaphone Sim");
	}

	@Override
	public void data() {
		System.out.println("Browsing internet using Vodaphone Sim");
	}

}
