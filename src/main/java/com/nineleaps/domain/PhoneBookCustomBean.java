package com.nineleaps.domain;

public class PhoneBookCustomBean {

	private String bookName;

	public PhoneBookCustomBean() {
		System.out.println("Constructor of PhoneBookCustomBean bean is called !! ");
	}

	public void customDestroy() throws Exception {
		
		System.out.println("Custom destroy method of PhoneBookCustomBean called !! ");
	}

	public void customInit() throws Exception {
		
		System.out.println("Custom Init method of PhoneBookCustomBean called !! ");
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	@Override
	public String toString() {
		return "PhoneBookCustomBean [bookName=" + bookName + "]";
	}
	
}
