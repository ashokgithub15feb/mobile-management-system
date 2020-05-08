package com.nineleaps.model.circuler;

import org.springframework.stereotype.Component;

@Component
public class AirtelDataPlane {

	private String dataPlaneName;
	
	private int amount;
	
	private VodaphoneDataPlane vodaphoneDataPlane;

	public AirtelDataPlane() {
	}
	
	public AirtelDataPlane(VodaphoneDataPlane vodaphoneDataPlane) {
		this.vodaphoneDataPlane = vodaphoneDataPlane;
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

	public VodaphoneDataPlane getVodaphoneDataPlane() {
		return vodaphoneDataPlane;
	}

	public void setVodaphoneDataPlane(VodaphoneDataPlane vodaphoneDataPlane) {
		this.vodaphoneDataPlane = vodaphoneDataPlane;
	}

	@Override
	public String toString() {
		return "AirtelDataPlane [dataPlaneName=" + dataPlaneName + ", amount=" + amount + ", vodaphoneDataPlane="
				+ vodaphoneDataPlane + "]";
	}
	
	public void getThePlane()
	{
		System.out.println("Data Plane Name: "+this.dataPlaneName+" :: "+"Amount: "+this.amount);
	}
}
