package com.nineleaps.service;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;

@Named
public class MobileCustomerService {

	private Provider<MobileCustomer> customer;
	
	@Inject
	public MobileCustomerService(Provider<MobileCustomer> customer) {
		this.customer = customer;
	}

	public MobileCustomerService() {
	}
	
	public Provider<MobileCustomer> getCustomer() {
		return customer;
	}

	public void setCustomer(Provider<MobileCustomer> customer) {
		this.customer = customer;
	}
	
	
}
