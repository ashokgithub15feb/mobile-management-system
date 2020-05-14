package com.nineleaps.model.event;

import java.util.List;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class EmailService implements ApplicationEventPublisherAware
{
	
	private List<String> blockList;
	
	private ApplicationEventPublisher publisher;
	
	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		
		this.publisher = applicationEventPublisher;
	}
	
	public void sendEmail(String address, String content)
	{
		if(blockList.contains(address))
		{
			this.publisher.publishEvent(new BlackListEvent(this, address, content));
		}
	}
	
	public EmailService() {
	}
	
	public List<String> getBlockList() {
		return blockList;
	}

	public void setBlockList(List<String> blockList) {
		this.blockList = blockList;
	}

	public ApplicationEventPublisher getPublisher() {
		return publisher;
	}

	public void setPublisher(ApplicationEventPublisher publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return "EmailService [blockList=" + blockList + ", publisher=" + publisher + "]";
	}
}
