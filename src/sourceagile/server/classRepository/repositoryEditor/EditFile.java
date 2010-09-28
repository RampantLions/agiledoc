package sourceagile.server.classRepository.repositoryEditor;

import java.io.ByteArrayInputStream;

import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.io.ISVNEditor;
import org.tmatesoft.svn.core.io.SVNRepository;
import org.tmatesoft.svn.core.io.diff.SVNDeltaGenerator;

import sourceagile.shared.ClassFile;

public class EditFile {

	public EditFile(SVNRepository repository, ClassFile classFile,
			String classSourceUpdated) throws SVNException {

		String filePath = classFile.getClassPath() + "/"
				+ classFile.getClassName();

		String logMessage = "Editing file: " + filePath;

		ISVNEditor repositoryEditor = repository.getCommitEditor(logMessage,
				null);

		repositoryEditor.openRoot(-1);

		repositoryEditor.openDir(classFile.getClassPath(), -1);

		repositoryEditor.openFile(filePath, -1);

		repositoryEditor.applyTextDelta(filePath, null);

		SVNDeltaGenerator deltaGenerator = new SVNDeltaGenerator();
		String checksum = deltaGenerator.sendDelta(filePath,
				new ByteArrayInputStream(classSourceUpdated.getBytes()),
				repositoryEditor, true);

		repositoryEditor.closeFile(filePath, checksum);

		repositoryEditor.closeDir();

		repositoryEditor.closeEdit();

	}

}
