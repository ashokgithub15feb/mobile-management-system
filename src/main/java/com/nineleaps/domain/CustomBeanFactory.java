package com.nineleaps.domain;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/*
 * 1. A bean implementing BeanFactoryPostProcessor is called when all bean definitions will have been loaded, but no beans 
 * will have been instantiated yet. This allows for overriding or adding properties even to eager-initializing beans. 
 * This will let you have access to all the beans that you have defined in XML or that are annotated (scanned via component-scan).
 *
 * 2. bean implementing BeanPostProcessor operate on bean (or object) instances which means that when the Spring IoC container 
 * instantiates a bean instance then BeanPostProcessor interfaces do their work.
 *
 * 3. BeanFactoryPostProcessor implementations are "called" during startup of the Spring context after all bean definitions 
 * will have been loaded while BeanPostProcessor are "called" when the Spring IoC container instantiates a bean
 * 
 * 
 * Configuration Life Cycle:
 * 
 * XML Configuration -> Bean Detection               -> BeanFactoryPostProcessor -> Bean Instantiation and dependency Injection -> BeanPostProcessor 
 * Annotation Config -> @Component scanning          -> BeanFactoryPostProcessor -> Bean Instantiation and dependency Injection -> BeanPostProcessor 
 * java Config       -> Read @Bean Method Signature  -> BeanFactoryPostProcessor -> Bean Instantiation and dependency Injection -> BeanPostProcessor
 */
public class CustomBeanFactory implements BeanFactoryPostProcessor
{

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		
		System.out.println("==============BeanFactoryPostProcessor=============");
		for(String beanName : beanFactory.getBeanDefinitionNames())
		{
			BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);
			
			System.out.println(beanDefinition.getDescription());
			
		}
	}
	
}
