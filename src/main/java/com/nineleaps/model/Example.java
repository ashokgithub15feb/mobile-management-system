package com.nineleaps.model;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

public class Example {

	private MessageSource message;

	public MessageSource getMessage() {
		return message;
	}

	@Autowired
	public void setMessage(MessageSource message) {
		this.message = message;
	}
	
	public void execute()
	{
		String message2 = this.message.getMessage("argument.required", new Object[] {"UserDao", "Required"}, Locale.ENGLISH);
		
		System.out.println(message2);
	}
}
