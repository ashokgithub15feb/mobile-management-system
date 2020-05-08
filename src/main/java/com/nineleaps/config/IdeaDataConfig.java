package com.nineleaps.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.nineleaps.model.Idea;

@Configuration
public class IdeaDataConfig {
	
	@Bean(name = "sim")
	@Lazy
	public Idea getIdeaData()
	{
		return new Idea();
	}
}
