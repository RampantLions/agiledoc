package sourceagile.client.serverCalls;

import sourceagile.shared.entities.entry.ClassFile;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ClassesDocletAsync {

	void getDoclet(ClassFile entry, AsyncCallback<ClassFile> callback);
}
