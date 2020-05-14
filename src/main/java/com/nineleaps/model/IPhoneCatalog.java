package com.nineleaps.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class IPhoneCatalog implements MobileProductCatalog {

	private String catalog;
	
	public IPhoneCatalog() {
	}
	
	@Autowired
	public IPhoneCatalog(String catalog) {
		this.catalog = catalog;
	}

	public String getCatalog() {
		return catalog;
	}

	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}

	@Override
	public String getMobileProductCatalog() {
		
		return catalog;
	}
	@Override
	public String toString() {
		return "IPhoneCatalog [catalog=" + catalog + "]";
	}
	
}
