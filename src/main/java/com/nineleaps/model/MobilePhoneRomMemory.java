package com.nineleaps.model;

public class MobilePhoneRomMemory {

		
	public MobilePhoneRomMemory() {
	}
	
	public static class RomFeature
	{
		private String fullName;

		private String romFeatures;
		
		private String speed;
		
		private String rates;
		
		private String memoryType;
		
		public RomFeature() {
		}

		public String getRomFeatures() {
			return romFeatures;
		}

		public void setRomFeatures(String romFeatures) {
			this.romFeatures = romFeatures;
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

		public String getFullName() {
			return fullName;
		}

		public void setFullName(String fullName) {
			this.fullName = fullName;
		}

		@Override
		public String toString() {
			return "RomFeature [fullName=" + fullName + ", romFeatures=" + romFeatures + ", speed=" + speed + ", rates="
					+ rates + ", memoryType=" + memoryType + "]";
		}
		
	}



	
}
