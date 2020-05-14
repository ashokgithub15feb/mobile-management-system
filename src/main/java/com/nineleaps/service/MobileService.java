package com.nineleaps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

@Component
public class MobileService {

	@Autowired(required = false)
	private String serviceLocation;
	
	public MobileService() {
	}
	
	public MobileService(String serviceLocation) {
		this.serviceLocation = serviceLocation;
	}

	public String getServiceLocation() {
		return serviceLocation;
	}

	//@Required can not apply any field and Constructor, we can apply only Setter method
	@Required
	public void setServiceLocation(String serviceLocation) {
		this.serviceLocation = serviceLocation;
	}
	
	
}
