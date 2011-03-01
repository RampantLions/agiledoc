package sourceagile.server.doclet.antlr.java;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.TokenRewriteStream;

import sourceagile.shared.entities.entry.ClassFile;

public class GetJavaTokens {

	public static CommonTokenStream loadClassDocumentationANTLR(ClassFile entry) {

		CharStream cs = new ANTLRStringStream(entry.getSourceCode());

		JavaLexer lexer = new JavaLexer(cs);

		TokenRewriteStream tokens = new TokenRewriteStream();
		tokens.setTokenSource(lexer);

		JavaParser parser = new JavaParser(tokens);

		// RuleReturnScope result = parser.compilationUnit();

		return tokens;
	}

}
