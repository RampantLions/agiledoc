package sourceagile.server.classRepository.repositoryEditor;

import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.io.SVNRepository;

import sourceagile.server.sourcelet.TokenizeClass;
import sourceagile.shared.ClassFile;
import sourceagile.shared.ClassTokens;

public class UpdateClassDescription {

	public UpdateClassDescription(SVNRepository repository,
			ClassFile classFile, String classDescription) throws SVNException {

		new TokenizeClass(classFile);

		String classSource = classFile.getTextContent();

		ClassTokens tokens = classFile.getTokens();

		String textBefore = classSource.substring(0,
				tokens.getClassDescriptionPositionInit());

		String textAfter = classSource.substring(
				tokens.getClassDescriptionPositionEnd(), classSource.length());

		String classSourceUpdated = textBefore
				+ getComment(classFile, classDescription) + textAfter;

		new EditFile(repository, classFile, classSourceUpdated);

	}

	private String getComment(ClassFile classFile, String classDescription) {

		String todo = "";
		if (classFile.getClassDoc().isTodo()) {

			todo = "\n * @todo";
		}

		String feature = "";
		if (classFile.getClassDoc().isFeature()) {

			feature = "\n * @feature";
		}

		String comment = "/** \n * " + classDescription + "\n * " + todo
				+ feature + " \n */ ";

		return comment;
	}

}
