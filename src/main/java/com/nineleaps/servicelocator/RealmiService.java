package com.nineleaps.servicelocator;

import org.springframework.stereotype.Service;

@Service(value = "Realmi")
public class RealmiService  implements AdapterService<Mobile>{
	
	@Override
	public void process(Mobile request) {
		
		System.out.println("Inside Realmi Service: "+request.toString());
	}
}
