package com.producer;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface CustomSource {

	@Output("default-channel")
	public MessageChannel sendMessageDefaultChannel();
	
	@Output("custom-channel")
	public MessageChannel sendMessageCustomChannel();
	
}

