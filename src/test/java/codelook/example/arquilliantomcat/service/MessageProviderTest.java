package codelook.example.arquilliantomcat.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import codelook.example.arquilliantomcat.entity.Message;

/*
 * Unit test for the MessageProvider class using
 * Mockito for mocking
 */
@RunWith(MockitoJUnitRunner.class)
public class MessageProviderTest {

	@Mock
	private Message message;
	
	@InjectMocks
	private MessageProvider underTest;
	
	@Test
	public void testGetOutputMessageSuccess() {
		
		String messageValue = "Message";

		when(message.getMessage()).thenReturn(messageValue);
		
		String result = underTest.getOutputMessage();
		
		assertThat(result, is(messageValue));
	}
}