package com.nineleaps.dto;

public class AirtelSimCardTypeDTO {

    private String simName;
    private String location;
    private String simType;
    
    public AirtelSimCardTypeDTO() {
	}

	public String getSimName() {
		return simName;
	}

	public void setSimName(String simName) {
		this.simName = simName;
	}

	public String getSimType() {
		return simType;
	}

	public void setSimType(String simType) {
		this.simType = simType;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "AirtelSimCardTypeDTO [simName=" + simName + ", simType=" + simType + ", location=" + location + "]";
	}
    
}
