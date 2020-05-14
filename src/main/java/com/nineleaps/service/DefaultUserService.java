package com.nineleaps.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class DefaultUserService implements UserService {

	@Override
	public void enableUser() {
		System.out.println("Default User Service");
	}

}
