package com.nineleaps;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.FileSystemResource;

import com.nineleaps.config.VodaphoneDataConfig;
import com.nineleaps.domain.AwareBeanImpl;
import com.nineleaps.domain.PhoneBook;
import com.nineleaps.domain.PhoneBookBean;
import com.nineleaps.domain.PhoneBookCustomBean;
import com.nineleaps.dto.AirtelSimCardTypeDTO;
import com.nineleaps.feedback.bean.AirtelCustomerFeedback;
import com.nineleaps.model.Airtel;
import com.nineleaps.model.BillPaymentByCreditCardDetails;
import com.nineleaps.model.CustomerNumbers;
import com.nineleaps.model.DeviceSlot;
import com.nineleaps.model.Idea;
import com.nineleaps.model.Mobile;
import com.nineleaps.model.MobilePhoneRamMemory;
import com.nineleaps.model.MobilePhoneRomMemory.RomFeature;
import com.nineleaps.model.Person;
import com.nineleaps.model.PhoneNumber;
import com.nineleaps.model.Processor;
import com.nineleaps.model.ProcessorBased;
import com.nineleaps.model.Vodaphone;
import com.nineleaps.model.circuler.AirtelDataPlane;
import com.nineleaps.model.circuler.VodaphoneDataPlane;
import com.nineleaps.model.compoundproperty.Bar;
//import com.nineleaps.model.circuler.AirtelDataPlane;
//import com.nineleaps.model.circuler.VodaphoneDataPlane;
import com.nineleaps.model.methodinjection.SimCardCountrySingleton;
import com.nineleaps.model.methodinjection.SimCardCountrySingletonAbstract;
import com.nineleaps.model.methodinjection.SimCardCountrySingletonAppContextAware;
import com.nineleaps.model.methodinjection.SimCardStatePrototype;
import com.nineleaps.model.methodinjection.SimCardStatePrototypeAbstractClassDependent;
import com.nineleaps.service.TimeService;

@SpringBootApplication
public class MobileManagementSystemApplication implements CommandLineRunner
{

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
		
		 ((AbstractApplicationContext) context).registerShutdownHook(); 
		 ((AbstractApplicationContext) context1).registerShutdownHook(); 
		 ((AbstractApplicationContext) context11).registerShutdownHook(); 
		 ((AbstractApplicationContext) context111).registerShutdownHook(); 
		 
//		((AbstractApplicationContext) context1).registerShutdownHook();

	}

	 @Autowired
	 private GenericApplicationContext context;
	 
	@Override
    public void run(String... args) throws Exception {

        context.registerBean("com.nineleaps.service.TimeService",
                TimeService.class, () -> new TimeService());

        TimeService timeService = (TimeService) context.getBean(TimeService.class);

        System.out.println("Instant get Time: "+timeService.getGetNow());

        context.registerShutdownHook();
    }
}
