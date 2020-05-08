package com.nineleaps.servicelocator;

import org.springframework.stereotype.Service;

@Service(value = "IPhoneApple")
public class IPhoneAppleService  implements AdapterService<Mobile>{
	
	@Override
	public void process(Mobile request) {
		
		System.out.println("Inside IPhoneApple Service: "+request.toString());
	}
}
