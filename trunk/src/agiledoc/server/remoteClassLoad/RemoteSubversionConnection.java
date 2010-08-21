package agiledoc.server.remoteClassLoad;

import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.auth.ISVNAuthenticationManager;
import org.tmatesoft.svn.core.internal.io.dav.DAVRepositoryFactory;
import org.tmatesoft.svn.core.io.SVNRepository;
import org.tmatesoft.svn.core.io.SVNRepositoryFactory;
import org.tmatesoft.svn.core.wc.SVNWCUtil;

public class RemoteSubversionConnection {

	public static SVNRepository connect() {

		// https://agiledoc.googlecode.com/svn/trunk/

		String url = "http://agiledoc.googlecode.com/svn/trunk/src/agiledoc/client";
		String name = "Alline.Oliveira";
		String password = "bD8Km8se2rV9";

		// SVNRepositoryFactoryImpl.setup();
		DAVRepositoryFactory.setup();

		SVNRepository repository = null;
		try {
			repository = SVNRepositoryFactory.create(SVNURL
					.parseURIDecoded(url));
			ISVNAuthenticationManager authManager = SVNWCUtil
					.createDefaultAuthenticationManager(name, password);
			repository.setAuthenticationManager(authManager);

		} catch (SVNException e) {
			// handle exception
		}

		return repository;

	}

}
