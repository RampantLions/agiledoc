package sourceagile.server.sourcelet.tokenizer;

import java.util.ArrayList;

import sourceagile.shared.ClassFile;

public class Tokenize {

	public static void getClassArrayIndex(ClassFile classFile) {

		ArrayList<String> tokenArray = new ArrayList<String>();

		String classSource = classFile.getSourceCode();

		new TokenizeComments(classSource, tokenArray);

		TokenizeClassDeclaration.getClassArrayIndex(classFile, tokenArray);

		classFile.setSourceCodeTokenized(tokenArray);

	}

}
