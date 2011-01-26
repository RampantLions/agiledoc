package sourceagile.server.doclet.tokenizer;

import java.util.ArrayList;

public class TokenizeComments {

	public TokenizeComments(String classSource, ArrayList<String> tokenArray) {

		splitSource(tokenArray, classSource, JavaTokens.JAVADOC_INIT_REGEX,
				JavaTokens.JAVADOC_INIT, JavaTokens.JAVADOC_END);

		Object[] splitArray = tokenArray.toArray();

		tokenArray.clear();

		for (int i = 0; i < splitArray.length; i++) {

			String tokenJavadoc = (String) splitArray[i];

			splitSource(tokenArray, tokenJavadoc, JavaTokens.COMMENT,
					JavaTokens.LINE_END);
		}

	}

	private void splitSource(ArrayList<String> tokenArray, String tokenString,
			String tokenInitial, String tokenEnd) {

		splitSource(tokenArray, tokenString, tokenInitial, tokenInitial,
				tokenEnd);
	}

	private void splitSource(ArrayList<String> tokenArray, String tokenString,
			String tokenInitialRegularExpression, String tokenInitial,
			String tokenEnd) {

		String[] splitArray = tokenString.split(tokenInitialRegularExpression);

		tokenArray.add(splitArray[0]);

		for (int i = 1; i < splitArray.length; i++) {

			String nextToken = tokenInitial + splitArray[i];

			int positionEnd = nextToken.indexOf(tokenEnd);

			String currentToken = nextToken.substring(0, positionEnd);

			tokenArray.add(currentToken + tokenEnd);

			nextToken = nextToken.substring(positionEnd + tokenEnd.length());

			splitSource(tokenArray, nextToken, tokenInitialRegularExpression,
					tokenInitial, tokenEnd);
		}
	}

}
