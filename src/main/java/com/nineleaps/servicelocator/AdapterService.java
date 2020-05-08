package com.nineleaps.servicelocator;

public interface AdapterService<T> {
	
	public void process(T request);
}
