package com.nineleaps.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class RatingRetrieverUnit {

	
	private List<Rating> ratings;

	public RatingRetrieverUnit() {
	}
	
	@Autowired
	public RatingRetrieverUnit(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	@Override
	public String toString() {
		return "RatingRetrieverUnit [ratings=" + ratings + "]";
	}
	
}
