package codelook.example.arquilliantomcat;

import java.io.File;

import org.jboss.shrinkwrap.api.Filters;
import org.jboss.shrinkwrap.api.GenericArchive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.importer.ExplodedImporter;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;

public class ArquillianDeployment {

	private static final String LOCAL_WEBAPP_DIR = "src/main/webapp";
	private static final String PACKAGE_NAME = "codelook.example.arquilliantomcat";

	public static WebArchive createDeployment() {

		File[] libs = Maven.resolver()
						.loadPomFromFile("pom.xml")
						.resolve("org.jboss.weld.servlet:weld-servlet")
						.withTransitivity().asFile();

		WebArchive archive = ShrinkWrap
				.create(WebArchive.class, "webapp.war")
				.merge(	ShrinkWrap.create(GenericArchive.class)
						.as(ExplodedImporter.class)
						.importDirectory(LOCAL_WEBAPP_DIR)
						.as(GenericArchive.class),
						Filters.includeAll()
						)
				.addPackages(true, Package.getPackage(PACKAGE_NAME))
				.addAsLibraries(libs);

		return archive;
	}
}