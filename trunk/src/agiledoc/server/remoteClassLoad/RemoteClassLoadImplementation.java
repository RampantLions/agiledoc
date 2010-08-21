package agiledoc.server.remoteClassLoad;

import java.util.Collection;
import java.util.List;

import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.io.SVNRepository;

import agiledoc.client.serverConnection.RemoteLoadFunctions;
import agiledoc.shared.Feature;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class RemoteClassLoadImplementation extends RemoteServiceServlet
		implements RemoteLoadFunctions {

	public List<Feature> ListFeatures() {

		List<Feature> features = null;

		try {
			SVNRepository repository = RemoteSubversionConnection.connect();

			Collection remoteClasses = RemoteClassLoad.listRemoteClasses(
					repository, "");

			features = RemoteClassLoad.getFeaturesList(remoteClasses);

		} catch (SVNException e) {
			// handle exception
		}

		return features;
	}

}
