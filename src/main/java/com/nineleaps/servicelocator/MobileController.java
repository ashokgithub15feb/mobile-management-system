package com.nineleaps.servicelocator;

//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping(value = "/mobiles")
public class MobileController {

	//@Autowired
	private ServiceResitory serviceResitory;
	
	//Internal Server Error 500
//	 public mobileController() {
//		 System.out.println("Default Constructor called!!!!!!");
//	 }
	
	public MobileController(ServiceResitory serviceResitory)
	{
		System.out.println("Argument Constructor called!!!!!!");
		this.serviceResitory = serviceResitory;
	}
	
//	@PostMapping
	public void processmobileDeatils(//@RequestBody 
			Mobile mobile)
	{
		serviceResitory.getService(mobile.getMobileType()).process(mobile);
	}
}
