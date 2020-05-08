package com.nineleaps.feedback.bean;

import org.springframework.beans.factory.annotation.Autowired;

public class AirtelCustomerFeedback {

	private int rating;

	private String feedback;
	
	@Autowired
	private AirtelPublicFeedback airtelPublicFeedback;
	
	@Autowired
	private AirtelRetailerFeedback airtelRetailerFeedback;
	
	public AirtelCustomerFeedback(int rating, String feedback) {
		super();
		this.rating = rating;
		this.feedback = feedback;
	}

	public AirtelCustomerFeedback() {
		System.out.println("AirtelRetailerFeedback Initialized");
	}

	public void doSomthing() {
		
		System.out.println("Inside doSomthing() method of AirtelCustomerFeedback Rating: "+getRating()+" :: Feedback: "+getFeedback());
		airtelPublicFeedback.doSomthing();
		airtelRetailerFeedback.doSomthing();
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
}
