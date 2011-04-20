package sourceagile.server.databaseAccess;

import java.util.Properties;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

/**
 * 
 * @Architecture
 */
public class DatabaseConnection {

	public static Properties getAppengineDatabaseProperties() {

		Properties properties = new Properties();

		properties
				.setProperty("javax.jdo.PersistenceManagerFactoryClass",
						"org.datanucleus.store.appengine.jdo.DatastoreJDOPersistenceManagerFactory");

		properties.setProperty("javax.jdo.option.ConnectionURL", "appengine");

		properties.setProperty("javax.jdo.option.NontransactionalRead", "true");
		properties
				.setProperty("javax.jdo.option.NontransactionalWrite", "true");
		properties.setProperty("javax.jdo.option.RetainValues", "true");
		properties.setProperty("datanucleus.appengine.autoCreateDatastoreTxns",
				"true");

		return properties;
	}

	public static Properties getLocalDatabaseProperties() {

		// String databasePath =
		// "C:\\eclipse\\workspace\\SourceAgile\\war\\data";
		String databasePath = "/var/lib/tomcat6/webapps/LiveSource/data";
		// String databasePath = "data";

		Properties properties = new Properties();

		properties.setProperty("javax.jdo.PersistenceManagerFactoryClass",
				"org.datanucleus.jdo.JDOPersistenceManagerFactory");
		properties.setProperty("javax.jdo.option.ConnectionDriverName",
				"org.apache.derby.jdbc.EmbeddedDriver");
		properties.setProperty("javax.jdo.option.ConnectionURL", "jdbc:derby:"
				+ databasePath);

		// properties.setProperty("javax.jdo.option.ConnectionURL",
		// "jdbc:derby:data;create=true");
		// properties.setProperty("datanucleus.autoCreateSchema", "true");
		// properties.setProperty("datanucleus.autoCreateColumns", "true");
		// properties.setProperty("datanucleus.storeManagerType", "rdbms");

		return properties;
	}

	public static PersistenceManager connect() {

		PersistenceManagerFactory PMF = JDOHelper
				.getPersistenceManagerFactory(getLocalDatabaseProperties());

		PersistenceManager persistenceManager = PMF.getPersistenceManager();

		return persistenceManager;
	}

}
