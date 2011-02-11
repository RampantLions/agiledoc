package sourceagile.server.classRepositories.subversionClassRepository.repositoryEditor;

import java.io.ByteArrayInputStream;

import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.io.ISVNEditor;
import org.tmatesoft.svn.core.io.SVNRepository;
import org.tmatesoft.svn.core.io.diff.SVNDeltaGenerator;

import sourceagile.shared.entities.entry.ClassFile;

public class EditFile {

	public EditFile(SVNRepository repository, ClassFile classFile,
			String classSourceUpdated) throws SVNException {

		String filePath = classFile.getFilePath() + "/"
				+ classFile.getFileName();

		String logMessage = "Editing file: " + filePath;

		ISVNEditor repositoryEditor = repository.getCommitEditor(logMessage,
				null);

		repositoryEditor.openRoot(-1);

		repositoryEditor.openDir(classFile.getFilePath(), -1);

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
