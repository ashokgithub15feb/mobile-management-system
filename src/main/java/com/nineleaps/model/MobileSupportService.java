package com.nineleaps.model;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class MobileSupportService {

	private Map<String, String> map;

	public MobileSupportService() {
	}

	public void send(String mailTo) {
		// Code for sending mail
		System.out.println("Inside send method - " + mailTo);
	}

	@PostConstruct
	public void init() {
		System.out.println("Inside init method - " + map);
	}

	@PreDestroy
	public void destroy() {
		map.clear();
		System.out.println("Inside destroy method - " + map);
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

}
