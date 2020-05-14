package com.nineleaps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.nineleaps.model.MobileProductCatalog;

//@Component
public class MobileCatalogService {

	//@Qualifier("samsungCatalog")
	private MobileProductCatalog catalog;

	public MobileProductCatalog getCatalog() {
		return catalog;
	}

	//@Autowired
	public void setCatalog(MobileProductCatalog catalog) {
		this.catalog = catalog;
	}

	@Override
	public String toString() {
		return "MobileCatalogService [catalog=" + catalog + "]";
	}
	
	
}
