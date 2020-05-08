package com.nineleaps.servicelocator;

import org.springframework.stereotype.Service;

@Service(value = "Samsung")
public class SamsungService  implements AdapterService<Mobile>{
	
	@Override
	public void process(Mobile request) {
		
		System.out.println("Inside Samsung Service: "+request.toString());
	}
}
