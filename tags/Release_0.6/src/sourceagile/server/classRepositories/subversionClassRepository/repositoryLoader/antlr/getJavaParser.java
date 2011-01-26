package sourceagile.server.classRepositories.subversionClassRepository.repositoryLoader.antlr;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;

import sourceagile.shared.entities.entry.ClassFile;

public class getJavaParser {
	
	public static void loadClassDocumentationANTLR(ByteArrayOutputStream baos,
			ClassFile entry) throws IOException {

		CharStream cs = new ANTLRStringStream(baos.toString());
		
		JavaLexer lexer = new JavaLexer(cs);
		
		CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(lexer);
		
		JavaParser parser = new JavaParser(tokens);
		
		//RuleReturnScope result = parser.compilationUnit();
	}

}
