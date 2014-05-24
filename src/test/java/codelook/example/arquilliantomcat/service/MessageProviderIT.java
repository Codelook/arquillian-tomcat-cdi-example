package codelook.example.arquilliantomcat.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import codelook.example.arquilliantomcat.ArquillianDeployment;

/*
 * Integration test injecting an actual object instance of the class
 * under test. Deployed into an embedded application server.
 */
@RunWith(Arquillian.class)
public class MessageProviderIT {

	@Inject
	private MessageProvider underTest;
	
	@Deployment
	public static WebArchive init() {

		return ArquillianDeployment.createDeployment();
	}
	
	@Test
	public void testGetOutputMessageSuccess() {
		
		String result = underTest.getOutputMessage();
		
		assertThat(result, is("Hello World"));
	}
}