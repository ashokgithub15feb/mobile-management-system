package com.nineleaps.model;

public class Mobile {

	private String mobileName;
	
	private String mobileModel;

	public Mobile() {
	}
	
	public Mobile(String mobileName, String mobileModel) {
		this.mobileName = mobileName;
		this.mobileModel = mobileModel;
	}

	public String getMobileName() {
		return mobileName;
	}

	public void setMobileName(String mobileName) {
		this.mobileName = mobileName;
	}

	public String getMobileModel() {
		return mobileModel;
	}

	public void setMobileModel(String mobileModel) {
		this.mobileModel = mobileModel;
	}

	@Override
	public String toString() {
		return "Mobile [mobileName=" + mobileName + ", mobileModel=" + mobileModel + "]";
	}
	
	
	
}
