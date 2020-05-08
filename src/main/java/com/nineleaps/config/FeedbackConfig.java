package com.nineleaps.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import com.nineleaps.feedback.bean.AirtelCustomerFeedback;
import com.nineleaps.feedback.bean.AirtelPublicFeedback;
import com.nineleaps.feedback.bean.AirtelRetailerFeedback;

@Configuration
public class FeedbackConfig {
	
	@Bean("airtelCustomerFeedback")
	@DependsOn(value = {"airtelPublicFeedback", "airtelRetailerFeedback"})
	public AirtelCustomerFeedback getAirtelCustomerFeedback()
	{
		return new AirtelCustomerFeedback(3, "Avg Service Providing");
	}
	
	@Bean("airtelPublicFeedback")
	public AirtelPublicFeedback getAirtelPublicFeedback()
	{
		return new AirtelPublicFeedback(4, "Good Service Providing");
	}
	
	@Bean("airtelRetailerFeedback")
	public AirtelRetailerFeedback getAirtelRetailerFeedback()
	{
		return new AirtelRetailerFeedback(4, "Very Good Service Providing");
	}
	
}
