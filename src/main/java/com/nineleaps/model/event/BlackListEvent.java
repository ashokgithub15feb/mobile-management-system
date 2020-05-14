package com.nineleaps.model.event;

import org.springframework.context.ApplicationEvent;

public class BlackListEvent extends ApplicationEvent{

	
	private final String address;
	
	private final String content;
	
	
	public BlackListEvent(Object source, String address, String content	) {
		super(source);
		
		this.address = address;
		this.content = content;
	}


	public String getAddress() {
		return address;
	}


	public String getContent() {
		return content;
	}


	@Override
	public String toString() {
		return "BlackListEvent [address=" + address + ", content=" + content + "]";
	}
	
}
