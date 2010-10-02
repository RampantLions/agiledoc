package sourceagile.server.sourcelet;

import java.util.ArrayList;

import sourceagile.shared.ClassFile;
/** 
 * Test
 *  
 */

public class TokenizeClassDeclaration {

	public static int getClassArrayIndex(ClassFile classFile,
			ArrayList<String> tokenArray) {

		String classDeclarationToken = JavaTokens.INTERFACE;

		int classTokenArrayIndex = indexArrayOfKeyword(tokenArray,
				JavaTokens.INTERFACE);

		if (classTokenArrayIndex < 0) {

			classTokenArrayIndex = indexArrayOfKeyword(tokenArray,
					JavaTokens.CLASS);

			classDeclarationToken = JavaTokens.CLASS;
		}

		ArrayList<String> tokenArrayAux = (ArrayList<String>) tokenArray
				.clone();

		tokenArray.clear();

		int classTokenIndex = -1;

		for (int i = 0; i < tokenArrayAux.size(); i++) {

			String nextToken = tokenArrayAux.get(i);

			if (i < classTokenArrayIndex
					&& !nextToken.startsWith(JavaTokens.JAVADOC_INIT)
					&& !nextToken.startsWith(JavaTokens.COMMENT)) {

				splitCommands(tokenArray, nextToken);

			} else {

				if (i == classTokenArrayIndex) {

					int classTokenPosition = nextToken
							.indexOf(classDeclarationToken);

					String stringToTokenize = nextToken.substring(0,
							classTokenPosition);

					splitCommands(tokenArray, stringToTokenize);

					classTokenIndex = tokenArray.size() - 1;

					String classToken = tokenArray.get(classTokenIndex)
							+ nextToken.substring(classTokenPosition);

					tokenArray.set(classTokenIndex, classToken);

				} else {

					tokenArray.add(nextToken);
				}
			}

		}

		return classTokenIndex;
	}

	private static int indexArrayOfKeyword(ArrayList<String> tokenArray,
			String keyword) {

		int index = -1;
		for (int i = 0; i < tokenArray.size(); i++) {

			String token = tokenArray.get(i);

			if (!token.startsWith(JavaTokens.JAVADOC_INIT)
					&& !token.startsWith(JavaTokens.COMMENT)
					&& token.contains(keyword)) {

				index = i;
				break;
			}
		}

		return index;
	}

	private static void splitCommands(ArrayList<String> tokenArray,
			String stringToTokenize) {

		String[] splitArray = stringToTokenize.split(JavaTokens.COMMAND_END);

		for (int j = 0; j < splitArray.length; j++) {

			String token = splitArray[j];

			if (j < splitArray.length - 1) {

				token += JavaTokens.COMMAND_END;
			}
			tokenArray.add(token);
		}
	}

}


public class TokenizeClassDeclaration {

	public static int getClassArrayIndex(ClassFile classFile,
			ArrayList<String> tokenArray) {

		String classDeclarationToken = JavaTokens.INTERFACE;

		int classTokenArrayIndex = indexArrayOfKeyword(tokenArray,
				JavaTokens.INTERFACE);

		if (classTokenArrayIndex < 0) {

			classTokenArrayIndex = indexArrayOfKeyword(tokenArray,
					JavaTokens.CLASS);

			classDeclarationToken = JavaTokens.CLASS;
		}

		ArrayList<String> tokenArrayAux = (ArrayList<String>) tokenArray
				.clone();

		tokenArray.clear();

		int classTokenIndex = -1;

		for (int i = 0; i < tokenArrayAux.size(); i++) {

			String nextToken = tokenArrayAux.get(i);

			if (i < classTokenArrayIndex
					&& !nextToken.startsWith(JavaTokens.JAVADOC_INIT)
					&& !nextToken.startsWith(JavaTokens.COMMENT)) {

				splitCommands(tokenArray, nextToken);

			} else {

				if (i == classTokenArrayIndex) {

					int classTokenPosition = nextToken
							.indexOf(classDeclarationToken);

					String stringToTokenize = nextToken.substring(0,
							classTokenPosition);

					splitCommands(tokenArray, stringToTokenize);

					classTokenIndex = tokenArray.size() - 1;

					String classToken = tokenArray.get(classTokenIndex)
							+ nextToken.substring(classTokenPosition);

					tokenArray.set(classTokenIndex, classToken);

				} else {

					tokenArray.add(nextToken);
				}
			}

		}

		return classTokenIndex;
	}

	private static int indexArrayOfKeyword(ArrayList<String> tokenArray,
			String keyword) {

		int index = -1;
		for (int i = 0; i < tokenArray.size(); i++) {

			String token = tokenArray.get(i);

			if (!token.startsWith(JavaTokens.JAVADOC_INIT)
					&& !token.startsWith(JavaTokens.COMMENT)
					&& token.contains(keyword)) {

				index = i;
				break;
			}
		}

		return index;
	}

	private static void splitCommands(ArrayList<String> tokenArray,
			String stringToTokenize) {

		String[] splitArray = stringToTokenize.split(JavaTokens.COMMAND_END);

		for (int j = 0; j < splitArray.length; j++) {

			String token = splitArray[j];

			if (j < splitArray.length - 1) {

				token += JavaTokens.COMMAND_END;
			}
			tokenArray.add(token);
		}
	}

}
