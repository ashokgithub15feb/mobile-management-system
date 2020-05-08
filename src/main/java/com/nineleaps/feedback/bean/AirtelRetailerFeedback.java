package com.nineleaps.feedback.bean;

public class AirtelRetailerFeedback {

	private int rating;
	private String feedback;
	
	public AirtelRetailerFeedback() {
		System.out.println("AirtelRetailerFeedback Initialized");
	}

	
	
	public AirtelRetailerFeedback(int rating, String feedback) {
		super();
		this.rating = rating;
		this.feedback = feedback;
	}



	public void doSomthing() {
		
		System.out.println("Inside doSomthing() method of AirtelRetailerFeedback: Rating: "+rating+" :: Feedback "+feedback);
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
