package com.nineleaps.servicelocator;


public interface ServiceResitory {
	
	public <T> AdapterService<T> getService(String serviceName);
}
