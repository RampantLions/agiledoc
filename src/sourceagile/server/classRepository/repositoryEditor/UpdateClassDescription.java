package sourceagile.server.classRepository.repositoryEditor;

import java.util.ArrayList;

import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.io.SVNRepository;

import sourceagile.server.sourcelet.JavaTokens;
import sourceagile.server.sourcelet.Tokenize;
import sourceagile.shared.ClassFile;

public class UpdateClassDescription {

	public UpdateClassDescription(SVNRepository repository,
			ClassFile classFile, String classDescription) throws SVNException {

		int classArrayIndex = Tokenize.getClassArrayIndex(classFile);

		ArrayList<String> classSourceTokenized = classFile
				.getSourceCodeTokenized();

		String classSourceUpdated = "";

		for (int i = 0; i < classSourceTokenized.size(); i++) {

			String token = classSourceTokenized.get(i);

			if (i == classArrayIndex - 1) {

				if (token.startsWith(JavaTokens.JAVADOC_INIT)) {

					token = getNewClassJavadoc(classFile, classDescription);

				} else {

					token += "\n"
							+ getNewClassJavadoc(classFile, classDescription);

					String classToken = classSourceTokenized
							.get(classArrayIndex);

					if (classToken.startsWith(JavaTokens.CAR_RETURN_CHAR)) {

						classToken = classToken.substring(1);

						classSourceTokenized.set(classArrayIndex, classToken);

						token += JavaTokens.CAR_RETURN_CHAR;
					}

					if (classToken.startsWith(JavaTokens.LINE_END)) {

						classToken = classToken.substring(1);

						classSourceTokenized.set(classArrayIndex, classToken);

						token += JavaTokens.LINE_END;
					}
				}
			}

			classSourceUpdated += token;
		}

		new EditFile(repository, classFile, classSourceUpdated);

	}

	private String getNewClassJavadoc(ClassFile classFile,
			String classDescription) {

		String todo = "";
		if (classFile.getClassDoc().isTodo()) {

			todo = "\n * @todo";
		}

		String feature = "";
		if (classFile.getClassDoc().isFeature()) {

			feature = "\n * @feature";
		}

		String comment = "/** \n * " + classDescription + "\n * " + todo
				+ feature + " \n */ \n";

		return comment;
	}

}
