package agiledoc.client.serverConnection;

import java.util.List;

import agiledoc.shared.Feature;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface RemoteLoadFunctionsAsync {

	void ListFeatures(AsyncCallback<List<Feature>> callback);

}
