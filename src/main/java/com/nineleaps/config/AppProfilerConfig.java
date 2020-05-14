//package com.nineleaps.config;
//
//import javax.inject.Named;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//
//import com.nineleaps.model.profile.InMemoryInventoryServiceImpl2;
//import com.nineleaps.model.profile.InventoryService;
//import com.nineleaps.model.profile.ProductionInventoryServiceImpl2;
//
//@Configuration
//public class AppProfilerConfig {
//	
//	@Bean("inMemoryInventoryServiceImpl2")
//	@Profile("dev")
//	//@Named("inMemoryInventoryServiceImpl2")
//	public InventoryService dataSource()
//	{
//		return new InMemoryInventoryServiceImpl2();
//	}
//	
//	@Bean("productionInventoryServiceImpl2")
//	@Profile("prod") 
//	//@Named("productionInventoryServiceImpl2")
//	public InventoryService jndiDataSource() {
//		
//		return new ProductionInventoryServiceImpl2();
//    }
//}
