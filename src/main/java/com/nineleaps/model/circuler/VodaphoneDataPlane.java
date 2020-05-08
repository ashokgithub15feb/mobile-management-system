package com.nineleaps.model.circuler;

import org.springframework.stereotype.Component;

@Component
public class VodaphoneDataPlane {

	private String dataPlaneName;
	
	private int amount;
	
	private AirtelDataPlane airtelDataPlane;
	
	public VodaphoneDataPlane() {
	}

	public String getDataPlaneName() {
		return dataPlaneName;
	}

	public void setDataPlaneName(String dataPlaneName) {
		this.dataPlaneName = dataPlaneName;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public AirtelDataPlane getAirtelDataPlane() {
		return airtelDataPlane;
	}

	public void setAirtelDataPlane(AirtelDataPlane airtelDataPlane) {
		this.airtelDataPlane = airtelDataPlane;
	}

	@Override
	public String toString() {
		return "VodaphoneDataPlane [dataPlaneName=" + dataPlaneName + ", amount=" + amount + ", airtelDataPlane="
				+ airtelDataPlane + "]";
	}
	
	public void getThePlane()
	{
		System.out.println("Data Plane Name: "+this.dataPlaneName+" :: "+"Amount: "+this.amount);
	}
}
