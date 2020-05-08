package com.nineleaps.servicelocator;

import java.io.Serializable;

public class Mobile implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2890530739566236868L;

	private String MobileName;
	
	private String MobileType;

	public Mobile() {
	}
	
	public String getMobileName() {
		return MobileName;
	}

	public void setMobileName(String MobileName) {
		this.MobileName = MobileName;
	}

	public String getMobileType() {
		return MobileType;
	}

	public void setMobileType(String MobileType) {
		this.MobileType = MobileType;
	}

	@Override
	public String toString() {
		return "Mobile [MobileName=" + MobileName + ", MobileType=" + MobileType + "]";
	}

	
	
}
