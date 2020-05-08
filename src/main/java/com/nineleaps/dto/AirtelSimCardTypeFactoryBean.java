package com.nineleaps.dto;

import org.springframework.beans.factory.config.AbstractFactoryBean;

//To create a factory bean, all you have to do is to implement the FactoryBean interface by your creator bean class 
//which will be creating actual other beans. Or to keep it simple, you can extend AbstractFactoryBean class.

//By extending the AbstractFactoryBean class, your factory bean can simply override the createInstance() 
//method to create the target bean instance. In addition, you have to return the target bean’s type in the getObjectType() method for the auto-wiring feature to work properly.
		
/*
 	Why use factory beans?
	Factory beans are mostly used to implement framework facilities. Here are some examples:
	
	1. When looking up an object (such as a data source) from JNDI, you can use JndiObjectFactoryBean.
	2. When using classic Spring AOP to create a proxy for a bean, you can use ProxyFactoryBean.
	3. When creating a Hibernate session factory in the IoC container, you can use LocalSessionFactoryBean.
	
	In most cases, you rarely have to write any custom factory beans, because they are framework-specific 
	and cannot be used outside the scope of the Spring IoC container.
*/

//In this example, I am creating a factory bean to instantiate different types of AirtelSimCardType objects e.g. 
//their Standard SIM, a smaller Micro SIM and smaller Nano SIM etc. with some pre-populated attributes.


public class AirtelSimCardTypeFactoryBean extends AbstractFactoryBean<Object>
{
	private String simType;
	
	public AirtelSimCardTypeFactoryBean() {
	}
	
	public String getSimType() {
		return simType;
	}

	public void setSimType(String simType) {
		this.simType = simType;
	}

	@Override
	public Class<?> getObjectType() {
		return AirtelSimCardTypeFactoryBean.class;
	}

	@Override
	protected Object createInstance() throws Exception {
		
		AirtelSimCardTypeDTO typeDTO = new AirtelSimCardTypeDTO();
		typeDTO.setSimName("Airtel");
		typeDTO.setLocation("Bangalore");
		
		//set SimType 
		typeDTO.setSimType(simType);
		
		return typeDTO;
	}
	
}
