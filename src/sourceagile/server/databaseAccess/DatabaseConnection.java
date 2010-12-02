package sourceagile.server.databaseAccess;

import java.util.Properties;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

public class DatabaseConnection {

	public static PersistenceManager connect() {

		Properties properties = new Properties();

		properties.setProperty("javax.jdo.PersistenceManagerFactoryClass",
				"org.datanucleus.jdo.JDOPersistenceManagerFactory");
		properties.setProperty("javax.jdo.option.ConnectionDriverName",
				"org.apache.derby.jdbc.EmbeddedDriver");
		properties.setProperty("javax.jdo.option.ConnectionURL",
				"jdbc:derby:data");

		// properties.setProperty("javax.jdo.option.ConnectionURL",
		// "jdbc:derby:data;create=true");
		// properties.setProperty("datanucleus.autoCreateSchema", "true");
		// properties.setProperty("datanucleus.autoCreateColumns", "true");
		// properties.setProperty("datanucleus.storeManagerType", "rdbms");

		PersistenceManagerFactory PMF = JDOHelper
				.getPersistenceManagerFactory(properties);

		PersistenceManager persistenceManager = PMF.getPersistenceManager();

		return persistenceManager;
	}

}
