package agiledoc.client.serverConnection;

import java.util.List;

import agiledoc.shared.Entry;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("remoteClassLoader")
public interface RemoteLoadFunctions extends RemoteService {

	public List<Entry> ListFeatures();

	public Entry getEntryFeature(Entry entry);
}
