package com.nineleaps.model;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanOne {

	private BeanTwo beanTwo;
	
	@Autowired
	public BeanOne(BeanTwo beanTwo) {
		this.beanTwo = beanTwo;
	}
	public BeanOne() {
	}

	//@Resource(name = "beanTwo")
	public void setBeanTwo(BeanTwo beanTwo) {
		this.beanTwo = beanTwo;
	}

	public void doSomething(){
	      System.out.println("Inside do doSomething() method of BeanOne");
	      beanTwo.doSomething();
	   }
}
