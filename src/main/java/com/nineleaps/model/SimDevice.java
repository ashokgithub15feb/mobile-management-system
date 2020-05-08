package com.nineleaps.model;

public class SimDevice {

	private int simSlotNum;
	
	private String primarySlotName;

	private String deviceName;
	
	private String ram;
	
	public SimDevice() {
	}
	
	public SimDevice(int simSlotNum, String primarySlotName, String deviceName, String ram) {
		this.simSlotNum = simSlotNum;
		this.primarySlotName = primarySlotName;
		this.deviceName = deviceName;
		this.ram = ram;
	}

	public int getSimSlotNum() {
		return simSlotNum;
	}

	public void setSimSlotNum(int simSlotNum) {
		this.simSlotNum = simSlotNum;
	}

	public String getPrimarySlotName() {
		return primarySlotName;
	}

	public void setPrimarySlotName(String primarySlotName) {
		this.primarySlotName = primarySlotName;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	
	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	@Override
	public String toString() {
		return "SimDevice [simSlotNum=" + simSlotNum + ", primarySlotName=" + primarySlotName + ", deviceName="
				+ deviceName + ", ram=" + ram + "]";
	}
	
	
}
