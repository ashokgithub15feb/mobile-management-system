package com.nineleaps.model;

public class ProcessorsCompany {

	private String qualcomm;
	
	private String mediaTek;
	
	private String samsung;
	
	private String apple;
	
	public ProcessorsCompany() {
	}

	public String getQualcomm() {
		return qualcomm;
	}

	public void setQualcomm(String qualcomm) {
		this.qualcomm = qualcomm;
	}

	public String getMediaTek() {
		return mediaTek;
	}

	public void setMediaTek(String mediaTek) {
		this.mediaTek = mediaTek;
	}

	public String getSamsung() {
		return samsung;
	}

	public void setSamsung(String samsung) {
		this.samsung = samsung;
	}

	public String getApple() {
		return apple;
	}

	public void setApple(String apple) {
		this.apple = apple;
	}

	@Override
	public String toString() {
		return "ProcessorsCompany [qualcomm=" + qualcomm + ", mediaTek=" + mediaTek + ", samsung=" + samsung
				+ ", apple=" + apple + "]";
	}
	
}
