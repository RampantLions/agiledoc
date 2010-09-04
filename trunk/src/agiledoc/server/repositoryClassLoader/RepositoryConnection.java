package agiledoc.server.repositoryClassLoader;

import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.auth.ISVNAuthenticationManager;
import org.tmatesoft.svn.core.internal.io.dav.DAVRepositoryFactory;
import org.tmatesoft.svn.core.io.SVNRepository;
import org.tmatesoft.svn.core.io.SVNRepositoryFactory;
import org.tmatesoft.svn.core.wc.SVNWCUtil;

public class RepositoryConnection {

	private static String repositoryURL = "http://agiledoc.googlecode.com";
	private static String repositoryPath = "/svn/trunk/src/";
	public static String domain = "agiledoc.client";
	private static String name = "Alline.Oliveira";
	private static String password = "bD8Km8se2rV9";

	public static SVNRepository connect() {

		// SVNRepositoryFactoryImpl.setup();
		DAVRepositoryFactory.setup();

		SVNRepository repository = null;
		try {

			repository = SVNRepositoryFactory.create(SVNURL
					.parseURIDecoded(getRepositoryURI()));
			ISVNAuthenticationManager authManager = SVNWCUtil
					.createDefaultAuthenticationManager(name, password);
			repository.setAuthenticationManager(authManager);

		} catch (SVNException e) {
			// handle exception
		}

		return repository;
	}

	public static String getRepositoryURI() {

		String domainURI = domain.replaceAll("\\.", "/");

		String URI = repositoryURL + repositoryPath + domainURI;

		return URI;
	}

}
