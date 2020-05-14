package com.nineleaps.model;

import org.springframework.stereotype.Component;

@Component
public class Samsung extends MobilePerformance {

	private String processorType;
	private String name;
    private String manufacturer;
	
    public String getProcessorType() {
		return processorType;
	}
	public void setProcessorType(String processorType) {
		this.processorType = processorType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Samsung(String processorType, String name, String manufacturer) {
		this.processorType = processorType;
		this.name = name;
		this.manufacturer = manufacturer;
	}
	
    public Samsung() {
	}

}
