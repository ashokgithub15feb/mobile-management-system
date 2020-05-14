package com.nineleaps.model;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class Message {
	
	private String[] sentMessage;
	
	private List<String> listMessages;
	
	private Set<String> setMessages;
	
	private Map<String, String> mapMessages;
	
    private Optional<String> optionalMessage;

	
	public Message() {
	}

	@Inject
	public Message(String[] sentMessage, List<String> listMessages, Set<String> setMessages,
			Map<String, String> mapMessages, Optional<String> optionalMessage) {
		this.sentMessage = sentMessage;
		this.listMessages = listMessages;
		this.setMessages = setMessages;
		this.mapMessages = mapMessages;
		this.optionalMessage = optionalMessage;
	}


	public String[] getSentMessage() {
		return sentMessage;
	}


	public void setSentMessage(String[] sentMessage) {
		this.sentMessage = sentMessage;
	}


	public List<String> getListMessages() {
		return listMessages;
	}


	public void setListMessages(List<String> listMessages) {
		this.listMessages = listMessages;
	}


	public Set<String> getSetMessages() {
		return setMessages;
	}


	public void setSetMessages(Set<String> setMessages) {
		this.setMessages = setMessages;
	}


	public Map<String, String> getMapMessages() {
		return mapMessages;
	}


	public void setMapMessages(Map<String, String> mapMessages) {
		this.mapMessages = mapMessages;
	}


	public Optional<String> getOptionalMessage() {
		return optionalMessage;
	}


	public void setOptionalMessage( @Nullable Optional<String> optionalMessage) {
		this.optionalMessage = optionalMessage;
	}


	@Override
	public String toString() {
		return "Message [sentMessage=" + Arrays.toString(sentMessage) + ", listMessages=" + listMessages
				+ ", setMessages=" + setMessages + ", mapMessages=" + mapMessages + ", optionalMessage="
				+ optionalMessage + "]";
	}
	

}
