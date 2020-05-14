package com.nineleaps.model.profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class ProductionInventoryServiceImpl2 implements InventoryService {

	@Override
	public void addStockItem(String itemName, int qty, int unitPrice) {
        System.out.println("adding item in ProductionInventoryServiceImpl: " + itemName);

	}

}
