package com.nineleaps.domain;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

public class PhoneBookBeanPostProcessor implements BeanPostProcessor, Ordered
{
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		
		System.out.println("Post Process Before Initialization method is called in PhoneBookBeanPostProcessor: Bean Name " + beanName);
		
		return bean;
	}
	
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		
		System.out.println("Post Process After Initialization method is called in PhoneBookBeanPostProcessor: Bean Name " + beanName);
		
		return bean;
	}

	@Override
	public int getOrder() {
		return 1;
	}
}
