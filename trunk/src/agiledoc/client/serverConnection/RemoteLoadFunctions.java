package agiledoc.client.serverConnection;

import java.util.List;

import agiledoc.shared.Feature;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;


@RemoteServiceRelativePath("remoteClassLoad")
public interface RemoteLoadFunctions extends RemoteService {

	List<Feature> ListFeatures();
}
