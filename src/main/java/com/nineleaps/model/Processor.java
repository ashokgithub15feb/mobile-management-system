package com.nineleaps.model;

public class Processor {

	private String process;
	
	private String ram;

	public Processor() {
	}
	
	public Processor(String process, String ram) {
		this.process = process;
		this.ram = ram;
	}

	public String getProcess() {
		return process;
	}

	public void setProcess(String process) {
		this.process = process;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	@Override
	public String toString() {
		return "Processor [process=" + process + ", ram=" + ram + "]";
	}
	
	
}
