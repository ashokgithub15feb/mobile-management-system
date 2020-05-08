package com.nineleaps.servicelocator;

import org.springframework.stereotype.Service;

@Service(value = "Nokia")
public class NokiaService implements AdapterService<Mobile>{
	
	@Override
	public void process(Mobile request) {
		
		System.out.println("Inside Nokia Service: "+request.toString());
	}
}
