package sourceagile.server.doclet;

import sourceagile.client.serverCalls.ClassesDoclet;
import sourceagile.server.doclet.antlr.java.ConvertTokensToDocumentation;
import sourceagile.server.doclet.antlr.java.GetJavaTokens;
import sourceagile.shared.entities.entry.ClassFile;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * 
 * @Architecture
 */
@SuppressWarnings("serial")
public class ClassesDocletImplementation extends RemoteServiceServlet implements
		ClassesDoclet {

	@Override
	public ClassFile getDoclet(ClassFile entry) {

		new ConvertTokensToDocumentation(entry,
				GetJavaTokens.loadClassDocumentationANTLR(entry));

		return null;
	}
}
