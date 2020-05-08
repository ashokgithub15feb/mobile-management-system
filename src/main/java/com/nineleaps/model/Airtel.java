package com.nineleaps.model;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

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
