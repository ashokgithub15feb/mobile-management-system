//package com.nineleaps.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//
////@Component
//public class OrderFacade {
//	
//	@Qualifier("userServiceImpl")
//	private UserService userService;
//
//	@Autowired
//	public OrderFacade(UserService userService) {
//		this.userService = userService;
//	}
//
//	public OrderFacade() {
//	}
//
//	public UserService getUserService() {
//		return userService;
//	}
//
//	public void setUserService(UserService userService) {
//		this.userService = userService;
//	}
//	
//	
//}
