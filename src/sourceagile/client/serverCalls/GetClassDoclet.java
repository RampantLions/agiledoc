package sourceagile.client.serverCalls;

import sourceagile.shared.entities.entry.ClassFile;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class GetClassDoclet {

	private final ClassesDocletAsync remoteFunctions = GWT
			.create(ClassesDoclet.class);

	public GetClassDoclet(ClassFile classFile) {

		remoteFunctions.getDoclet(classFile, new AsyncCallback<ClassFile>() {

			public void onSuccess(ClassFile classFile) {

				classFile.getClassDoc();
			}

			public void onFailure(Throwable caught) {
				// Show the RPC error message to the user

			}

		});

	}

}
