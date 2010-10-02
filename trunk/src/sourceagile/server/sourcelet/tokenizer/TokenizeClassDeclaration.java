package sourceagile.server.sourcelet.tokenizer;

import java.util.ArrayList;

import sourceagile.shared.ClassFile;


/** 
 * TODO: Use the enum Tokens from JDK source code.
 * 
 * @todo 
 */

public class TokenizeClassDeclaration {

	public static void getClassArrayIndex(ClassFile classFile,
			ArrayList<String> tokenArray) {

		ArrayList<String> tokenArrayAux = (ArrayList<String>) tokenArray
				.clone();

		tokenArray.clear();

		boolean isCommand = true;

		for (int i = 0; i < tokenArrayAux.size(); i++) {

			String nextToken = tokenArrayAux.get(i);

			if (isCommand && !nextToken.startsWith(JavaTokens.JAVADOC_INIT)
					&& !nextToken.startsWith(JavaTokens.COMMENT)) {

				isCommand = tokenizeCommands(tokenArray, nextToken);

			} else {

				tokenArray.add(nextToken);
			}
		}
	}

	private static boolean tokenizeCommands(ArrayList<String> tokenArray,
			String nextToken) {

		boolean isCommand = true;

		int nextLinePositionEnd = nextToken.indexOf(JavaTokens.COMMAND_END);

		int classTokenPosition = getClassTokenPosition(nextToken);

		if ((nextLinePositionEnd != -1)
				&& (classTokenPosition >= 0 && nextLinePositionEnd < classTokenPosition)) {

			tokenArray.add(nextToken.substring(0, nextLinePositionEnd
					+ JavaTokens.COMMAND_END.length()));

			nextToken = nextToken.substring(nextLinePositionEnd
					+ JavaTokens.COMMAND_END.length());

			isCommand = tokenizeCommands(tokenArray, nextToken);

		} else {

			tokenArray.add(nextToken);

			isCommand = false;
		}

		return isCommand;
	}

	public static int getClassTokenPosition(String nextToken) {

		int classTokenPosition = nextToken.indexOf(JavaTokens.CLASS);

		if (classTokenPosition >= 0) {

			return classTokenPosition;

		} else {

			int interfaceTokenPosition = nextToken
					.indexOf(JavaTokens.INTERFACE);

			return interfaceTokenPosition;
		}
	}

}
