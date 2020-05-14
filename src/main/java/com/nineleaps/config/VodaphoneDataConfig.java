package com.nineleaps.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Scope;

import com.nineleaps.domain.MobileAccountService;
import com.nineleaps.feedback.bean.AirtelCustomerFeedback;
import com.nineleaps.feedback.bean.AirtelPublicFeedback;
import com.nineleaps.feedback.bean.AirtelRetailerFeedback;
import com.nineleaps.model.Idea;
import com.nineleaps.model.Vodaphone;
import com.nineleaps.service.MobileService;

@Configuration
@Import(value = {Idea.class})
@ImportResource(locations = {"config.xml"})
public class VodaphoneDataConfig {
	
	@Bean(name = "sim")
	public Vodaphone getVodaphoneData()
	{
		return new Vodaphone();
	}
	
	//Feedback Configuration
	
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
		return new AirtelRetailerFeedback(5, "Very Good Service Providing");
	}
	
	//@Component
	@Bean
	public MobileService getMobileServiceLocation()
	{
		MobileService mobileService = new MobileService();
		mobileService.setServiceLocation("Bangalore");
		
		return mobileService;
	}
	
}
