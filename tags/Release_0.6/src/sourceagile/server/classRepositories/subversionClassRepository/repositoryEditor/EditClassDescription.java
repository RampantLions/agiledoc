package sourceagile.server.classRepositories.subversionClassRepository.repositoryEditor;

import java.util.ArrayList;

import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.io.SVNRepository;

import sourceagile.server.sourcelet.tokenizer.JavaTokens;
import sourceagile.server.sourcelet.tokenizer.Tokenize;
import sourceagile.server.sourcelet.tokenizer.TokenizeClassDeclaration;
import sourceagile.shared.entities.entry.ClassDocumentation;
import sourceagile.shared.entities.entry.ClassFile;

public class EditClassDescription {

	public EditClassDescription(SVNRepository repository, ClassFile classFile,
			String classDescription) throws SVNException {

		Tokenize.getClassArrayIndex(classFile);

		ArrayList<String> classSourceTokenized = classFile
				.getSourceCodeTokenized();

		for (int i = 0; i < classSourceTokenized.size(); i++) {

			String token = classSourceTokenized.get(i);

			if (!token.startsWith(JavaTokens.JAVADOC_INIT)
					&& !token.startsWith(JavaTokens.COMMENT)
					&& TokenizeClassDeclaration.getClassTokenPosition(token) >= 0) {

				classSourceTokenized
						.set(i, getNewClassJavadoc(classFile, classDescription)
								+ token);

				if (classSourceTokenized.get(i - 1).startsWith(
						JavaTokens.JAVADOC_INIT)) {

					classSourceTokenized.set(i - 1, "");
				}

				break;
			}
		}

		String classSourceUpdated = "";

		for (int i = 0; i < classSourceTokenized.size(); i++) {

			classSourceUpdated += classSourceTokenized.get(i);
		}

		new EditFile(repository, classFile, classSourceUpdated);

	}

	private String getNewClassJavadoc(ClassFile classFile,
			String classDescription) {

		String todo = "";
		if (classFile.getClassDoc().isTodo()) {

			todo = "\n * @" + ClassDocumentation.TODO_TAG;
		}

		String tagType = "";

		if (classFile.getClassDoc().getTagType() != null) {

			if (classFile.getClassDoc().getTagType()
					.equals(ClassDocumentation.USER_FEATURE_TAG)) {

				tagType = "\n * @" + ClassDocumentation.USER_FEATURE_TAG;

			} else if (classFile.getClassDoc().getTagType()
					.equals(ClassDocumentation.FEATURE_TAG)) {

				tagType = "\n * @" + ClassDocumentation.FEATURE_TAG;

			} else if (classFile.getClassDoc().getTagType()
					.equals(ClassDocumentation.ARCHITECTURE_TAG)) {

				tagType = "\n * @" + ClassDocumentation.ARCHITECTURE_TAG;

			} else if (classFile.getClassDoc().getTagType()
					.equals(ClassDocumentation.ENTITY_TAG)) {

				tagType = "\n * @" + ClassDocumentation.ENTITY_TAG;
			}
		}

		String comment = "\n\n/** \n * " + classDescription + "\n * " + todo
				+ tagType + " \n */";

		return comment;
	}

}
