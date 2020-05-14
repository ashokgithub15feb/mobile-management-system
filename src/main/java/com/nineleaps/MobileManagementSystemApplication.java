package com.nineleaps;

import java.util.Locale;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.FileSystemResource;

//import com.nineleaps.config.AppProfilerConfig;
import com.nineleaps.config.CommanConfig;
import com.nineleaps.config.DBProperties;
import com.nineleaps.config.VodaphoneDataConfig;
import com.nineleaps.domain.AwareBeanImpl;
import com.nineleaps.domain.MobileAccountService;
import com.nineleaps.domain.PhoneBook;
import com.nineleaps.domain.PhoneBookBean;
import com.nineleaps.domain.PhoneBookCustomBean;
import com.nineleaps.dto.AirtelSimCardTypeDTO;
import com.nineleaps.feedback.bean.AirtelCustomerFeedback;
import com.nineleaps.model.Airtel;
import com.nineleaps.model.BeanOne;
import com.nineleaps.model.BillPaymentByCreditCardDetails;
import com.nineleaps.model.City;
import com.nineleaps.model.CustomerNumbers;
import com.nineleaps.model.DeviceSlot;
import com.nineleaps.model.IPhone;
import com.nineleaps.model.Idea;
import com.nineleaps.model.Message;
import com.nineleaps.model.Mobile;
import com.nineleaps.model.MobilePhoneRamMemory;
import com.nineleaps.model.MobilePhoneRomMemory.RomFeature;
import com.nineleaps.model.MobileProductCatalog;
import com.nineleaps.model.MobileSupportService;
import com.nineleaps.model.Person;
import com.nineleaps.model.PhoneNumber;
import com.nineleaps.model.Processor;
import com.nineleaps.model.ProcessorBased;
import com.nineleaps.model.RatingRetrieverUnit;
import com.nineleaps.model.Samsung;
import com.nineleaps.model.Vodaphone;
import com.nineleaps.model.aop.service.FactoryService;
import com.nineleaps.model.aop.service.ShapeService;
import com.nineleaps.model.circuler.AirtelDataPlane;
import com.nineleaps.model.circuler.VodaphoneDataPlane;
import com.nineleaps.model.compoundproperty.Bar;
import com.nineleaps.model.event.EmailService;
//import com.nineleaps.model.circuler.AirtelDataPlane;
//import com.nineleaps.model.circuler.VodaphoneDataPlane;
import com.nineleaps.model.methodinjection.SimCardCountrySingleton;
import com.nineleaps.model.methodinjection.SimCardCountrySingletonAbstract;
import com.nineleaps.model.methodinjection.SimCardCountrySingletonAppContextAware;
import com.nineleaps.model.methodinjection.SimCardStatePrototype;
import com.nineleaps.model.methodinjection.SimCardStatePrototypeAbstractClassDependent;
import com.nineleaps.model.profile.InMemoryInventoryServiceImpl;
import com.nineleaps.model.profile.ProductionInventoryServiceImpl;
import com.nineleaps.repository.CityRepository;
import com.nineleaps.service.DefaultUserService;
import com.nineleaps.service.MobileCustomerService;
import com.nineleaps.service.MobileService;
//import com.nineleaps.service.OrderFacade;
import com.nineleaps.service.TimeService;

@SpringBootApplication
public class MobileManagementSystemApplication implements CommandLineRunner
{
	 @Autowired
	 private GenericApplicationContext context;
	
	 @Autowired
	 private CityRepository cityRepository;
	

	public static void main(String[] args) {
		//SpringApplication.run(MobileManagementSystemApplication.class, args);
		
		ApplicationContext context111 = new ClassPathXmlApplicationContext("config.xml");
		
		//Load config file using Resource object
		ApplicationContext context1 = new ClassPathXmlApplicationContext();
		String location1 = "C:\\Users\\Ashok\\Downloads\\Nineleaps_poc\\Workshop\\mobile-management-system\\src\\main\\resources\\config.xml";
		context1.getResource(location1 );
		
		//Load the config file using BeanFactory IoC COntainer
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("config.xml");
		
		//Load the config file using FileSystemXmlApplicationContext class
		String configFile = "C:\\Users\\Ashok\\Downloads\\Nineleaps_poc\\Workshop\\mobile-management-system\\src\\main\\resources\\config.xml";
		ApplicationContext context11 = new FileSystemXmlApplicationContext (configFile );
				
		
		//Spring Boot GenericApplicationContext
		 TimeService timeService = new TimeService();
		  DefaultListableBeanFactory parentBeanFactory = new DefaultListableBeanFactory();  
		  parentBeanFactory.registerSingleton("getNowTime", timeService);

		  GenericApplicationContext parentContext = new GenericApplicationContext(parentBeanFactory);

		  XmlBeanDefinitionReader xmlReader = new XmlBeanDefinitionReader(parentContext);
		  String location = "C:\\Users\\Ashok\\Downloads\\Nineleaps_poc\\Workshop\\mobile-management-system\\src\\main\\resources\\config.xml";
		  xmlReader.loadBeanDefinitions(new FileSystemResource(location));
		   parentContext.refresh();

		   TimeService timeServiceBean = (TimeService ) parentContext.getBean("timeService");
		   System.out.println("Time Servie Get Time Now: "+timeServiceBean.getGetNowTime());
		   System.out.println("Time Servie Get Time Instant.Now(): "+timeServiceBean.getGetNow()); 
		
		
		AnnotationConfigApplicationContext context = 
	            new AnnotationConfigApplicationContext(VodaphoneDataConfig.class);
		System.out.println("==============================");
		
		Airtel airtelBean = context.getBean(Airtel.class);
		airtelBean.calling();
		airtelBean.data();
		
		System.out.println("==============================");
		
		Vodaphone vodaphoneBean = context.getBean(Vodaphone.class);
		vodaphoneBean.calling();
		vodaphoneBean.data();
		
		System.out.println("==============================");
		
		Idea ideaBean = context.getBean(Idea.class);
		ideaBean.calling();
		ideaBean.data();
		
		System.out.println("=============================================================================");
		
		AirtelCustomerFeedback airtelCustomerFeedback = context.getBean(AirtelCustomerFeedback.class);
		airtelCustomerFeedback.doSomthing();
		
		System.out.println("=============================================================================");
			
		Person person = context.getBean(Person.class);
		System.out.println("Person Id: "+person.getId());
		System.out.println("Person Name: "+person.getName());
		System.out.println("Person Age: "+person.getAge());
		System.out.println("Person Address: "+person.getAddress());
		System.out.println("Person Phone Number: "+person.getPhoneNumber());
		
		System.out.println("=============================================================================");
		CustomerNumbers numbers = context.getBean(CustomerNumbers.class);
		System.out.println("List: "+numbers.getLists());
		System.out.println("Sets: "+numbers.getSets());
		System.out.println("Maps: "+numbers.getMaps());
		System.out.println("Props: "+numbers.getProperties());
		
		System.out.println("=============================================================================");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		AwareBeanImpl awareBeanImpl = context.getBean(AwareBeanImpl.class);
		
		PhoneBookBean bean = (PhoneBookBean) context.getBean("bookBeanPost");
		System.out.println(bean.getBookName());

		PhoneBook phoneBookbean = (PhoneBook) context.getBean("bookBean");
		System.out.println(phoneBookbean.getPhoneBookName());
		
		PhoneBookCustomBean beanCust = (PhoneBookCustomBean) context.getBean("bookCustomBean");
		System.out.println(beanCust.getBookName());

		
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		//registerSingleton
		ConfigurableApplicationContext configContext  = (ConfigurableApplicationContext) context;
		//The BeanFactory interface provides an advanced configuration mechanism capable of managing any type of object. 
		//ApplicationContext is a sub-interface of BeanFactory
		ConfigurableListableBeanFactory beanRegistry  = configContext .getBeanFactory();
		
		String beanName = "cellNumber";
		Object singletonObject = new PhoneNumber();
		beanRegistry.registerSingleton(beanName, singletonObject);
		
		 beanRegistry.destroySingletons();
		 
		 System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		 
		 Mobile mobileBean = (Mobile)context.getBean("mobile");
		 System.out.println(mobileBean.getMobileModel());
		 System.out.println(mobileBean.getMobileName());
		
		 Processor process1 = (Processor) context.getBean("process1");
		 System.out.println(process1.getProcess());
		 System.out.println(process1.getRam());
		 
		 Processor process2 = (Processor) context.getBean("process2");
		 System.out.println(process2.getProcess());
		 System.out.println(process2.getRam());
		 
		 System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		 
		 ProcessorBased processorBased = (ProcessorBased) context.getBean("processorBased");
		 System.out.println(processorBased.getProcessorsCompany().getQualcomm());
		 System.out.println(processorBased.getProcessorsCompany().getMediaTek());
		 System.out.println(processorBased.getProcessorsCompany().getSamsung());
		 System.out.println(processorBased.getProcessorsCompany().getApple());
		 
		 System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		 System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		 
		 //Bean Definition Inheritance
		 MobilePhoneRamMemory ram = (MobilePhoneRamMemory) context.getBean("ramBean");
		 System.out.println("RAM Full Name: "+ram.getFullName());
		 System.out.println("RAM Features: "+ram.getRamFeatures());
		 System.out.println("RAM Speed: "+ram.getSpeed());
		 System.out.println("RAM Speed Rates: "+ram.getRates());
		 System.out.println("RAM Memory Type: "+ram.getMemoryType());
		 
		 System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		 System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		 
		 RomFeature rom = (RomFeature) context.getBean("romFeature");
		 System.out.println("ROM Full Name: "+rom.getFullName());
		 System.out.println("ROM Features: "+rom.getRomFeatures());
		 System.out.println("ROM Speed: "+rom.getSpeed());
		 System.out.println("ROM Speed Rates: "+rom.getRates());
		 System.out.println("ROM Memory Type: "+rom.getMemoryType());
		 
		 System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		 System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		 System.out.println("...........................Factory Bean...............................");
		 AirtelSimCardTypeDTO standardSIMBean = (AirtelSimCardTypeDTO) context.getBean("standardSIM");
		 System.out.println(standardSIMBean.getSimName());
		 System.out.println(standardSIMBean.getSimType());
		 System.out.println(standardSIMBean.getLocation());
		 
		 System.out.println("..........................................................");
		 AirtelSimCardTypeDTO microSIMBean = (AirtelSimCardTypeDTO) context.getBean("microSIM");
		 System.out.println(microSIMBean.getSimName());
		 System.out.println(microSIMBean.getSimType());
		 System.out.println(microSIMBean.getLocation());
		 
		 System.out.println("..........................................................");
		 AirtelSimCardTypeDTO nanoSIMBean = (AirtelSimCardTypeDTO) context.getBean("nano-SIM");
		 System.out.println(nanoSIMBean.getSimName());
		 System.out.println(nanoSIMBean.getSimType());
		 System.out.println(nanoSIMBean.getLocation());
		 
		 System.out.println("..........................................................");
		 
		 //Method Injection
		 SimCardCountrySingleton simCardCountrySingleton = (SimCardCountrySingleton) context.getBean("simCardCountry");
		 SimCardStatePrototype cardStatePrototypeA = simCardCountrySingleton.getCardStatePrototype();
		 SimCardStatePrototype cardStatePrototypeB = simCardCountrySingleton.getCardStatePrototype();
		 
		 System.out.println("Sim Card Type Name: "+cardStatePrototypeA.getSimCardType());
		 System.out.println("Sim Card State Name: "+cardStatePrototypeB.getSimStateName());
		 System.out.println("Sim Card Country Name: "+simCardCountrySingleton.getSimCountryName());
		 System.out.println("Is cardStatePrototypeA and cardStatePrototypeB  same ? "+(cardStatePrototypeA == cardStatePrototypeB));
		
		 System.out.println("............................................................");
		
		 SimCardCountrySingletonAbstract simCardCountrySingletonAbs = (SimCardCountrySingletonAbstract) context.getBean("simCardCountryAbs");
		 SimCardStatePrototypeAbstractClassDependent cardStatePrototypeAbsA = simCardCountrySingletonAbs.getSimCardStatePrototypeAbstractClassDependent();
		 SimCardStatePrototypeAbstractClassDependent cardStatePrototypeAbsB = simCardCountrySingletonAbs.getSimCardStatePrototypeAbstractClassDependent();
		 
		 System.out.println("Sim Card Type Name: "+cardStatePrototypeAbsA.getSimCardType());
		 System.out.println("Sim Card State Name: "+cardStatePrototypeAbsB.getSimStateName());
		 System.out.println("Sim Card Country Name: "+simCardCountrySingletonAbs.getSimCountryName());
		 System.out.println("Is cardStatePrototypeAbsA and cardStatePrototypeAbsB  same ? "+(cardStatePrototypeAbsA == cardStatePrototypeAbsB));
		
		 System.out.println("............................................................");
			
		 //ApplicationContextAware not working
		 SimCardCountrySingletonAppContextAware simCardCountrySingletonAware = (SimCardCountrySingletonAppContextAware) context.getBean("simCardCountryAware");
		 
		 SimCardStatePrototype simCardStatePrototypeAwareA = simCardCountrySingletonAware.getCardStatePrototype();
		 SimCardStatePrototype simCardStatePrototypeAwareB = simCardCountrySingletonAware.getCardStatePrototype();
		 
		 //System.out.println("Sim Card Type Name: "+simCardStatePrototypeAwareA.getSimCardType());
		 //System.out.println("Sim Card State Name: "+simCardStatePrototypeAwareB.getSimStateName());
		 System.out.println("Sim Card Country Name: "+simCardCountrySingletonAware.getSimCountryName());
		 System.out.println("Is SimCardStatePrototypeAwareA and SimCardStatePrototypeAwareB  same ? "+(simCardStatePrototypeAwareA == simCardStatePrototypeAwareB));
		
		 System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		 System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		 
		 //Circular Dependency
		 AirtelDataPlane airtelDataPlane = (AirtelDataPlane) context.getBean("airtelDataPlane");
		 airtelDataPlane.getThePlane();
		 VodaphoneDataPlane vodaphoneDataPlane = (VodaphoneDataPlane) context.getBean("vodaphoneDataPlaneBean");
		 vodaphoneDataPlane.getThePlane();
		 
		 System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		 System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		 //Property editor - NW
		 BillPaymentByCreditCardDetails cardDetails = (BillPaymentByCreditCardDetails) context.getBean("cardDetails");
		 System.out.println("Raw Card Number: "+cardDetails.getRawCardNumber());
		 System.out.println("Account No: "+cardDetails.getAccountNo());
		 System.out.println("BankId No: "+cardDetails.getBankIdNo());
		 System.out.println("Check Code: "+cardDetails.getCheckCode());
		 
		 System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		 System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		 //Collection Merging
		 DeviceSlot deviceSlot = (DeviceSlot) context.getBean("deviceSlot");
		 deviceSlot.displayResult();
		
		 DeviceSlot deviceSlotChile = (DeviceSlot) context.getBean("chileCollection");
		 deviceSlotChile.displayResult();

		 System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		 System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		 //Compound Property
		 Bar bar = (Bar) context.getBean("compoundPropertyName");
		 System.out.println(bar.getFoo().getFred().getBob().getJhon());
		
		 System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		 System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		 //method replacement 
//		 DeviceDesign deviceDesign = (DeviceDesign) context.getBean("device");
//		 deviceDesign.getCircuit();
//		 deviceDesign.getDesign();
		
		 System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		 System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		 MobileSupportService mobileSupportService= (MobileSupportService) context.getBean("supportService");

		 System.out.println("--------------------------------------------------------------------------------");
		 System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		 
		 //@Component
		 MobileService mobileService = context.getBean(MobileService.class);
		 System.out.println(mobileService.getServiceLocation());
		 
		 System.out.println("--------------------------------------------------------------------------------");
		 System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		 
//||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||		 
		 AnnotationConfigApplicationContext commanConfig = 
				 new AnnotationConfigApplicationContext(CommanConfig.class);
		 
		 // ConfigurableBeanFactory EXAMPLE
		 MobileAccountService mobileAccountService = commanConfig.getBean("mobileAccountService", MobileAccountService.class);
		 mobileAccountService.setAccountHolder("Raunak");
		 System.out.println("Mobile Account Holder set Name: 1-> "+mobileAccountService.getAccountHolder());
		 
		 MobileAccountService mobileAccountService2 = commanConfig.getBean("mobileAccountService", MobileAccountService.class);
		 System.out.println("Mobile Account Holder Name: 2-> "+mobileAccountService2.getAccountHolder());
		 
		 System.out.println("--------------------------------------------------------------------------------");
		 System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		 
	     ConfigurableApplicationContext contextdb = 
	    		 new AnnotationConfigApplicationContext(CommanConfig.class, DBProperties.class);
	     
//		ConfigurableEnvironment environment = contextdb.getEnvironment();
//		environment.setActiveProfiles("dev");
	     DBProperties dbProperties = contextdb.getBean(DBProperties.class);
		 System.out.println(dbProperties.toString());
		 
		 System.out.println("--------------------------------------------------------------------------------");
		 System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		 
		// Customer customerProperty = (Customer)context1.getBean("customerBeanProprty");
		 //System.out.println(customerProperty.toString());
		
		 System.out.println("--------------------------------------------------------------------------------");
		 System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		 
		 Message message = commanConfig.getBean(Message.class);
		 System.out.println(message.toString());
		 
		 System.out.println("--------------------------------------------------------------------------------");
		 System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		 
		 //@Order
		 RatingRetrieverUnit rating = commanConfig.getBean(RatingRetrieverUnit.class);
		 System.out.println("Get Order Rating is: "+rating.getRatings().get(0).getRating()+" Excellent");
		 System.out.println("Get Order Rating is: "+rating.getRatings().get(1).getRating()+" Good");
		 System.out.println("Get Order Rating is: "+rating.getRatings().get(2).getRating()+" Average");
		 
		 System.out.println("--------------------------------------------------------------------------------");
		 System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		 
		 //@Primery
		 MobileProductCatalog mobileProductCatalog = commanConfig.getBean(MobileProductCatalog.class);
		 System.out.println(mobileProductCatalog.getMobileProductCatalog());
		 
//		 MobileCatalogService mobileCatalogService = commanConfig.getBean(MobileCatalogService.class);
//		 System.out.println(mobileCatalogService.getCatalog().getMobileProductCatalog());
		 
		 System.out.println("--------------------------------------------------------------------------------");
		 System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		 
		 //@Qualifier
		 DefaultUserService defaultUserService = commanConfig.getBean(DefaultUserService.class);
		 defaultUserService.enableUser();
		 
		 System.out.println("=============================================================================");
		 System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			
		 //@Resourse
		 BeanOne beanOne = commanConfig.getBean(BeanOne.class);
		 beanOne.doSomething();
		 
		 System.out.println("=============================================================================");
		 System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		 //Custom Qualifier
		 Samsung samsung = commanConfig.getBean(Samsung.class);
		 System.out.println("Samsung-Manufacturer: "+samsung.getManufacturer());
		 System.out.println("Samsung-Name: "+samsung.getName());
		 System.out.println("Samsung-ProcessorType: "+samsung.getProcessorType());
		 System.out.println("hashCode-"+samsung.hashCode());
		 System.out.println();
		 IPhone iPhone1 = commanConfig.getBean(IPhone.class);
		 System.out.println("iPhone-Manufacturer: "+iPhone1.getManufacturer());
		 System.out.println("iPhone-Name: "+iPhone1.getName());
		 System.out.println("iPhone-ProcessorType: "+iPhone1.getProcessorType());
		 System.out.println("hashCode-"+iPhone1.hashCode());
		 System.out.println();
		 IPhone iPhone2 = commanConfig.getBean(IPhone.class);
		 System.out.println("iPhone-Manufacturer: "+iPhone2.getManufacturer());
		 System.out.println("iPhone-Name: "+iPhone2.getName());
		 System.out.println("iPhone-ProcessorType: "+iPhone2.getProcessorType());
		 System.out.println("hashCode-"+iPhone2.hashCode());
		 
		 System.out.println("=============================================================================");
		 System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		 
		 //@Named, @Inject, Provider -allowing for on-demand access to beans of shorter scopes or lazy access to other beans through a Provider.get() call
		 
//		 MobileCustomerService mobileCustomerService = commanConfig.getBean(MobileCustomerService.class);
		 MobileCustomerService mobileCustomerService = (MobileCustomerService) commanConfig.getBean("customBeanNameMobileCustomerService");
		 
		 System.out.println(mobileCustomerService.getCustomer().get().getMobileMsg());
		 
		 System.out.println("=============================================================================");
		 System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		 
		 commanConfig.getEnvironment().setActiveProfiles("dev", "prod");
		 InMemoryInventoryServiceImpl inMemoryInventoryServiceImpl = commanConfig.getBean(InMemoryInventoryServiceImpl.class);
		 inMemoryInventoryServiceImpl.addStockItem("Item1", 12, 10000);
		 
		 ProductionInventoryServiceImpl productionInventoryServiceImpl = commanConfig.getBean(ProductionInventoryServiceImpl.class);
		 productionInventoryServiceImpl.addStockItem("Item2", 20, 20000);
		 
		 
		 System.out.println("=============================================================================");
		 System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		 
		 //Profile
//		 AnnotationConfigApplicationContext context2 = new AnnotationConfigApplicationContext(AppProfilerConfig.class);
//		 context2.getEnvironment().setActiveProfiles("dev");
//		 //context2.register(AppProfilerConfig.class);
//		 
//		 InMemoryInventoryServiceImpl2 inventoryService = context2.getBean(InMemoryInventoryServiceImpl2.class);
//		 inventoryService.addStockItem("Mobile", 2, 2000);
		 
		 //context2.refresh();
//		 context2.close();
		 System.out.println("=============================================================================");
		 System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		 
		 MessageSource  messageSource  = new ClassPathXmlApplicationContext("config.xml");
		 String message2 = messageSource.getMessage("message", null, "Default" ,Locale.ENGLISH);
		 System.out.println(message2);
		 
		 String message3 = messageSource.getMessage("message1", null ,Locale.US);
		 System.out.println(message3);
		 
//		 String message4 = messageSource.getMessage("argument.required", new Object[] {"UserDao", "Required"}, Locale.ENGLISH);
//		 System.out.println(message4);
		 
		 System.out.println("=============================================================================");
		 System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		 
		 ApplicationContext ctx = new ClassPathXmlApplicationContext("eventPublisher.xml");
		 EmailService emailService = (EmailService) ctx.getBean("emailService1");
		 
		 emailService.sendEmail("john.doe@example.org", "John is Black List because having a Criminal Record in Police Station.");
		 
		 System.out.println("=============================================================================");
		 System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		 
		 ((AbstractApplicationContext) contextdb).registerShutdownHook(); 
		 ((AbstractApplicationContext) commanConfig).registerShutdownHook(); 
		 ((AbstractApplicationContext) context).registerShutdownHook(); 
		 ((AbstractApplicationContext) context1).registerShutdownHook(); 
		 ((AbstractApplicationContext) context11).registerShutdownHook(); 
		 ((AbstractApplicationContext) context111).registerShutdownHook(); 
		 ((AbstractApplicationContext) ctx).registerShutdownHook(); 
		 
		 System.out.println("=============================================================================");
		 System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		 
		 //AOP Programming
		 
		ApplicationContext contextAOP = new ClassPathXmlApplicationContext("aopconfig.xml");
			ShapeService shapeService = contextAOP.getBean("shapeService", ShapeService.class);
			shapeService.getCircle();
			//shapeService.getCircle().setName("Dummy Argumenets");
			//shapeService.getCircle().setNameAndRetrun("Dummy Argumenets");
			//System.out.println(shapeService.getCircle().getName());
			
//			System.out.println(shapeService.getTriangle().getName());
			
				
			((AbstractApplicationContext) contextAOP).close(); 
			
			
		 //Proxy Factory class
//			FactoryService factoryService= FactoryService.getInstance();
//			ShapeService shapeService = (ShapeService) factoryService.getBean("shapeService");
//			
//			shapeService.getCircle();

			 System.out.println("=============================================================================");
			 System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

	}

		
	@Override
    public void run(String... args) throws Exception {

        context.registerBean("com.nineleaps.service.TimeService",
                TimeService.class, () -> new TimeService());

        TimeService timeService = (TimeService) context.getBean(TimeService.class);

        System.out.println("Instant get Time: "+timeService.getGetNow());

        context.registerShutdownHook();
        
        cityRepository.save(new City("Bratislava", 432000));
        cityRepository.save(new City("Budapest", 1759000));
        cityRepository.save(new City("Prague", 1280000));
        cityRepository.save(new City("Warsaw", 1748000));
        cityRepository.save(new City("Los Angeles", 3971000));
        cityRepository.save(new City("New York", 8550000));
        cityRepository.save(new City("Edinburgh", 464000));

        System.out.println("City count: "+cityRepository.count());
    }
}
