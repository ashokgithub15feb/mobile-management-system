package com.nineleaps.model;

public class MobilePhoneRamMemory {

	private String fullName;
	
	private String ramFeatures;
	
	private String speed;
	
	private String rates;
	
	private String memoryType;

	public MobilePhoneRamMemory() {
	}
	
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getRamFeatures() {
		return ramFeatures;
	}

	public void setRamFeatures(String ramFeatures) {
		this.ramFeatures = ramFeatures;
	}

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	public String getRates() {
		return rates;
	}

	public void setRates(String rates) {
		this.rates = rates;
	}

	public String getMemoryType() {
		return memoryType;
	}

	public void setMemoryType(String memoryType) {
		this.memoryType = memoryType;
	}

	@Override
	public String toString() {
		return "MobilePhoneRamMemory [fullName=" + fullName + ", ramFeatures=" + ramFeatures + ", speed=" + speed
				+ ", rates=" + rates + ", memoryType=" + memoryType + "]";
	}
	
	
}
