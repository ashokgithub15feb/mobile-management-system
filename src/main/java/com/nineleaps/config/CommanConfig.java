package com.nineleaps.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.inject.Provider;
import javax.inject.Singleton;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

import com.nineleaps.domain.MobileAccountService;
import com.nineleaps.model.Average;
import com.nineleaps.model.BeanOne;
import com.nineleaps.model.BeanTwo;
import com.nineleaps.model.Excellent;
import com.nineleaps.model.Good;
import com.nineleaps.model.IPhone;
import com.nineleaps.model.IPhoneCatalog;
import com.nineleaps.model.Message;
import com.nineleaps.model.MobilePerformance;
import com.nineleaps.model.MobileProductCatalog;
import com.nineleaps.model.MobileQualifier;
import com.nineleaps.model.MobileQualifier.Format;
import com.nineleaps.model.Rating;
import com.nineleaps.model.RatingRetrieverUnit;
import com.nineleaps.model.Samsung;
import com.nineleaps.model.SamsungCatalog;
import com.nineleaps.model.profile.InMemoryInventoryServiceImpl;
import com.nineleaps.model.profile.ProductionInventoryServiceImpl;
import com.nineleaps.service.DefaultUserService;
import com.nineleaps.service.MobileCustomer;
import com.nineleaps.service.MobileCustomerService;
import com.nineleaps.service.UserService;
import com.nineleaps.service.UserServiceImpl;

@Configuration
//@ComponentScan("com.nineleaps")
public class CommanConfig {

	//ConfigurableBeanFactory
	@Bean("mobileAccountService")
	//@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public MobileAccountService getMobileAccountService()
	{
		return new MobileAccountService();
	}
	
	@Bean
	public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer()
	{
		PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
		configurer.setLocation(new ClassPathResource("application.properties"));
		return configurer;
	}
	
	@Bean
	public Message getMessage()
	{
		String[] sentMessage = {"Hi", "Hello"}; 
		
		List<String> listMessages = new ArrayList<String>();
		listMessages.add("Bangalore");
		listMessages.add("Bangal");
		
		Set<String> setMessages = new HashSet<String>();
		setMessages.add("Delhi");
		setMessages.add("Mumbai");
		setMessages.add("Delhi");
		
		Map<String, String> mapMessages = new HashMap<String, String>();
		mapMessages.put("Lucknow", "Uttar Pradesh");
		mapMessages.put("Bangalore", "Karnataka");
		
		Optional<String> optionalMessage = Optional.of("Optioanl Hello");
		Message message = new Message(sentMessage, listMessages, setMessages, mapMessages, optionalMessage);
				
		return message;
	}
	
	@Bean
	public RatingRetrieverUnit getRatingRetrieverUnit()
	{
		List<Rating> ratings = new ArrayList<>();
		ratings.add(new Excellent());
		ratings.add(new Good());
		ratings.add(new Average());

		RatingRetrieverUnit ratingRetrieverUnit = new RatingRetrieverUnit(ratings);
		
		return ratingRetrieverUnit;
	}
	
	@Bean
	public MobileProductCatalog getSamsungProductCatalog()
	{
		SamsungCatalog samsungCatalog = new SamsungCatalog("Samsung");
		
		return samsungCatalog;
		
	}
	
	@Bean
	@Primary
	public MobileProductCatalog getiPhoneProductCatalog()
	{
		IPhoneCatalog iPhoneCatalog = new IPhoneCatalog("iPhone");
		
		return iPhoneCatalog;
	}
	
	@Bean
    @Qualifier("userServiceImpl")
	public UserService getUserService()
	{
		UserServiceImpl userService = new UserServiceImpl();
		
		return userService;
	}
	
	@Bean
    @Qualifier("defaultUserService")
	public UserService getDefaultUserService()
	{
		DefaultUserService userService = new DefaultUserService();
		
		return userService;
	}

	@Bean
	public BeanTwo getBeanTwo()
	{
		return new BeanTwo();
	}
	
	@Bean
	public BeanOne getBeanOne()
	{
		BeanOne beanOne = new BeanOne(new BeanTwo());
		
		return beanOne;
	}
	
	@Bean
	@MobileQualifier(genre = "Qualcomm", format = Format.P1)
	@Singleton
	public MobilePerformance getSamsung()
	{
		return new Samsung("2GHz", "Qualcomm", "Koria");
	}
	
	@Bean
	@MobileQualifier(genre = "Qualcomm", format = Format.P2)
	@Scope(value="singleton")
	public MobilePerformance getiPhone()
	{
		return new IPhone("4GHz", "Qualcomm", "USA");
	}

	@Bean(name = "customBeanNameMobileCustomerService")
	@Description("Mobile Customer Service")
	@Singleton
	public MobileCustomerService getMobileCustomerService()
	{
		Provider<MobileCustomer> mobileCustomer = new Provider<MobileCustomer>() {
			@Override
			public MobileCustomer get() {

				return new MobileCustomer();
			}
		};
		return new MobileCustomerService(mobileCustomer); 
	}
	
	@Bean
	public InMemoryInventoryServiceImpl getInMemoryInventoryServiceImpl()
	{
		return new InMemoryInventoryServiceImpl();
	}
	
	@Bean
	public ProductionInventoryServiceImpl getProductionInventoryServiceImpl()
	{
		return new ProductionInventoryServiceImpl();
	}
	
}
