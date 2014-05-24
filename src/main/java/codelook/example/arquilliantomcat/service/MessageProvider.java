package codelook.example.arquilliantomcat.service;

import javax.inject.Inject;

import codelook.example.arquilliantomcat.entity.Message;

public class MessageProvider {

	@Inject
	private Message message;
	
	public String getOutputMessage() {
		
		return message.getMessage();
	}
}