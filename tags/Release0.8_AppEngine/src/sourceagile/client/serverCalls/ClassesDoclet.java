package sourceagile.client.serverCalls;

import sourceagile.shared.entities.entry.ClassFile;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("classesDoclet")
public interface ClassesDoclet extends RemoteService {

	ClassFile getDoclet(ClassFile entry);
}
