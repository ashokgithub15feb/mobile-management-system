package com.nineleaps.model.aop.service;

import com.nineleaps.model.aop.aspect.LoggingAspect;
import com.nineleaps.model.aop.model.Circle;

public class ShapeServiceProxy extends ShapeService{

	@Override
	public Circle getCircle() {
		
		new LoggingAspect().loggingAdvice();
		return super.getCircle();
	}
}
