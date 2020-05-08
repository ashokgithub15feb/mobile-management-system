package com.nineleaps.domain;

public class PhoneBookBean {

	private String bookName;
	
	public PhoneBookBean() {
		System.out.println("Constructor of PhoneBookBean called !!");
	}
	
	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	@Override
	public String toString() {
		return "PhoneBookBean [bookName=" + bookName + "]";
	}
	
}
