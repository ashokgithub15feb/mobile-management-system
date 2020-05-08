package com.nineleaps.model;

import java.util.List;

public class DeviceSlot {

	private int slotNum;
	
	private String simSlotName;;
	
	private List<SimDevice> devices;
	
	public DeviceSlot() {
	}

	public DeviceSlot(int slotNum, String simSlotName, List<SimDevice> devices) {
		this.slotNum = slotNum;
		this.simSlotName = simSlotName;
		this.devices = devices;
	}

	public int getSlotNum() {
		return slotNum;
	}

	public void setSlotNum(int slotNum) {
		this.slotNum = slotNum;
	}

	public String getSimSlotName() {
		return simSlotName;
	}

	public void setSimSlotName(String simSlotName) {
		this.simSlotName = simSlotName;
	}

	public List<SimDevice> getDevices() {
		return devices;
	}

	public void setDevices(List<SimDevice> devices) {
		this.devices = devices;
	}

	public void displayResult() {
        System.out.println("Slot Num is :" + slotNum + " and Sim Slot Name is " + simSlotName);
        System.out.println("SimDevice are:");
        
        devices.stream().forEach(System.out::println);
 
    }
}
