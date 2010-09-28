package sourceagile.server.sourcelet;

import sourceagile.shared.ClassFile;
import sourceagile.shared.ClassTokens;

public class TokenizeClass {

	public TokenizeClass(ClassFile classFile) {

		ClassTokens tokens = new ClassTokens();

		String classSource = classFile.getTextContent();

		tokens.setPackagePosition(classSource.indexOf("package"));

		tokens.setClassPosition(classSource.indexOf("class"));
		if (tokens.getClassPosition() < 0) {

			tokens.setClassPosition(classSource.indexOf("interface"));
		}

		int commentInitPosition = classSource.indexOf("/*");

		if (commentInitPosition < tokens.getClassPosition()) {

			tokens.setClassDescriptionPositionInit(commentInitPosition);

			if (tokens.getClassDescriptionPositionInit() > 0) {

				tokens.setClassDescriptionPositionEnd(classSource.indexOf("*/",
						commentInitPosition) + 2);
			}
		}

		classFile.setTokens(tokens);

	}

}
