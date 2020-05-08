package com.nineleaps.model;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;

public class NewCircuit implements MethodReplacer
{
	@Override
	public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
		
		System.out.println("New Circuit");
		
		return obj;
	}
}
