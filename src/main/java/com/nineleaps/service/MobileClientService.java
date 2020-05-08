package com.nineleaps.service;

public class MobileClientService {

	private static MobileClientService mobileClientService = new MobileClientService();
	
	private static MobileClientService mobileClientService1 = new MobileClientService();
	
	private MobileClientService() {
		System.out.println("Priver Constructor called - MobileClientService ");
	}
	
	public static MobileClientService createInstance()
	{
		System.out.println("Inside MobileClientService.createInstance() method :: Fectory Method");
		return mobileClientService;
	}
	
	public void getMsg()
	{
		System.out.println("Mobile Client Instance Created");
	}
}
