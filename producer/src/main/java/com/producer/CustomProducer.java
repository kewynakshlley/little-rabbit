package com.producer;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.support.MessageBuilder;

import com.producer.dto.MessageDTO;



@EnableBinding(CustomSource.class)
public class CustomProducer {
	private String mySimpleMessage = "This is my simple message";
	private String customMessage = "This is my custom message";

	@Bean
	@InboundChannelAdapter(channel="default-channel", poller= @Poller(fixedDelay="2000"))
	public String sendMessageDefault() {
		return mySimpleMessage;
	}
	
	@Bean
	@InboundChannelAdapter(channel="custom-channel", poller=@Poller(fixedDelay="3000"))
	public MessageSource<MessageDTO> sendCustomMessage() {
		return () -> MessageBuilder.withPayload(new MessageDTO(customMessage)).build();
	}
}
