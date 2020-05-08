package com.nineleaps.model;

public class Idea implements Sim 
{

	public Idea() {
		System.out.println("Idea Constructor called!!!!");
	}
	
	@Override
	public void calling() {
		System.out.println("Idea Constructor called!!!!!");

	}

	@Override
	public void data() {
		System.out.println("Browsing internet using Vodaphone Sim");

	}

}
