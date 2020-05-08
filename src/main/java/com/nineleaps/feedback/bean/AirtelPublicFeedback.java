package com.nineleaps.feedback.bean;

public class AirtelPublicFeedback {

	private int rating;
	private String feedback;
	
	public AirtelPublicFeedback() {
		System.out.println("AirtelPublicFeedback Initialized");
	}
	
	public AirtelPublicFeedback(int rating, String feedback) {
		this.rating = rating;
		this.feedback = feedback;
	}


	public void doSomthing() {
		
		System.out.println("Inside doSomthing() method of AirtelPublicFeedback: Rating: "+rating+" :: Feedback "+feedback);
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
