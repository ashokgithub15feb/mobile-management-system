package com.nineleaps.service;

import java.time.Instant;

//TimeService contains a simple method which returns current date and time. 
//This service class is going to be registered in our generic application context.

public class TimeService {

	private Instant getNow;
	
	private String getNowTime;
	
	public TimeService() {
	}

	public Instant getGetNow() {
		return getNow;
	}

	public void setGetNow(Instant getNow) {
		this.getNow = getNow;
	}

	public String getGetNowTime() {
		return getNowTime;
	}

	public void setGetNowTime(String getNowTime) {
		this.getNowTime = getNowTime;
	}
	
	
	
}
