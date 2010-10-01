package sourceagile.server.sourcelet;

import java.util.ArrayList;

import sourceagile.shared.ClassFile;

public class Tokenize {

	public static int getClassArrayIndex(ClassFile classFile) {

		ArrayList<String> tokenArray = new ArrayList<String>();

		String classSource = classFile.getSourceCode();

		new TokenizeComments(classSource, tokenArray);

		int classArrayIndex = TokenizeClassDeclaration.getClassArrayIndex(
				classFile, tokenArray);

		classFile.setSourceCodeTokenized(tokenArray);

		return classArrayIndex;
	}

}
