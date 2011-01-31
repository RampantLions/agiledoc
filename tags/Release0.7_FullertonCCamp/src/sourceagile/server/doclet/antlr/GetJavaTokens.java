package sourceagile.server.doclet.antlr;

import java.io.ByteArrayOutputStream;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;

import sourceagile.shared.entities.entry.ClassFile;

public class GetJavaTokens {

	public static void loadClassDocumentationANTLR(ByteArrayOutputStream baos,
			ClassFile entry) {

		CharStream cs = new ANTLRStringStream(baos.toString());

		JavaLexer lexer = new JavaLexer(cs);

		CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(lexer);

		// JavaParser parser = new JavaParser(tokens);

		// RuleReturnScope result = parser.compilationUnit();
	}

}
