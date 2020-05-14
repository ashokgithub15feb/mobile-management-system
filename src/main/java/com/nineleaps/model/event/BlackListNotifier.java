package com.nineleaps.model.event;

import org.springframework.context.ApplicationListener;

public class BlackListNotifier implements ApplicationListener<BlackListEvent>{

	private String notificationAddress;
	
	
	@Override
	public void onApplicationEvent(BlackListEvent event) {
		
		System.out.println("Black List Event: Email Address is: "+event.getAddress()+"\nContent is: "+event.getContent());
	}


	public String getNotificationAddress() {
		return notificationAddress;
	}


	public void setNotificationAddress(String notificationAddress) {
		this.notificationAddress = notificationAddress;
	}

	
}
