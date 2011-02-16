package sourceagile.server.doclet.antlr;

import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Token;

import sourceagile.shared.entities.entry.ClassFile;

public class ConvertTokensToDocumentation {

	private static final String SEMI = ";";

	private static final String PACKAGE = "package";
	private static final String IMPORT = "import";
	private static final String CLASS = "class";
	private static final String INTERFACE = "interface";

	public ConvertTokensToDocumentation(ClassFile classFile,
			CommonTokenStream tokens) {

		List<Token> lisTokens = tokens.getTokens();

		int packageEnd = getPackage(classFile, lisTokens);

		getImports(packageEnd, classFile, lisTokens);
	}

	private int getPackage(ClassFile classFile, List<Token> tokens) {

		String classPackage = "";
		int commandEnd = 0;

		for (int i = 0; i < tokens.size(); i++) {

			Token token = tokens.get(i);

			if (token.getText().equals(PACKAGE)) {

				for (commandEnd = i + 2; commandEnd < tokens.size(); commandEnd++) {

					token = tokens.get(commandEnd);

					if (token.getText().equals(SEMI)) {

						for (int k = i + 2; k < commandEnd; k++) {

							token = tokens.get(k);

							classPackage += token.getText();
						}

						break;
					}
				}

				break;
			}

			break;
		}

		classFile.getClassDoc().setClassPackage(classPackage);

		return commandEnd;
	}

	private int getImports(int packageEnd, ClassFile classFile,
			List<Token> tokens) {

		ArrayList<String> classImports = new ArrayList<String>();
		String classImport = "";
		int commandEnd = packageEnd;

		for (int i = packageEnd; i < tokens.size(); i++) {

			Token token = tokens.get(i);

			if (!token.getText().equals(CLASS)
					&& !token.getText().equals(INTERFACE)) {

				if (token.getText().equals(IMPORT)) {

					classImport = "";

					for (commandEnd = i + 2; commandEnd < tokens.size(); commandEnd++) {

						token = tokens.get(commandEnd);

						if (token.getText().equals(SEMI)) {

							for (int k = i + 2; k < commandEnd; k++) {

								token = tokens.get(k);

								classImport += token.getText();
							}

							break;
						}
					}

					classImports.add(classImport);
					i = commandEnd;
				}

			} else {

				break;
			}
		}

		// classFile.getClassDoc().setImports((String[])
		// classImports.toArray());

		return commandEnd;
	}
}
