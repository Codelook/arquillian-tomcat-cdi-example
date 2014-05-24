package codelook.example.arquilliantomcat.servlet;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class MainServletIT {

	@ArquillianResource(MainServlet.class)
	URL contextPath;

	@Deployment(testable = false)
	public static WebArchive init() {

		return ArquillianDeployment.createDeployment();
	}

	@Test
	public void tryTest() throws IOException {

		InputStream stream = contextPath.openStream();
		String resp = IOUtils.toString(stream);

		assertThat(resp, is("Hello World"));
	}
}