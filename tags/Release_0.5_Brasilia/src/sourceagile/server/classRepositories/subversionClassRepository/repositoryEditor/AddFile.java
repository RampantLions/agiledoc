package sourceagile.server.classRepositories.subversionClassRepository.repositoryEditor;

import java.io.ByteArrayInputStream;

import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.io.ISVNEditor;
import org.tmatesoft.svn.core.io.SVNRepository;
import org.tmatesoft.svn.core.io.diff.SVNDeltaGenerator;

public class AddFile {

	public AddFile(SVNRepository repository, String parentFolderName,
			String newSubFolderName, String fileName, String fileContent)
			throws SVNException {

		String logMessage = "Creating file: " + fileName;

		ISVNEditor repositoryEditor = repository.getCommitEditor(logMessage,
				null);

		repositoryEditor.openRoot(-1);

		repositoryEditor.openDir(parentFolderName, -1);

		if (newSubFolderName != null) {

			repositoryEditor.addDir(newSubFolderName, null, -1);
		}

		repositoryEditor.addFile(fileName, null, -1);

		repositoryEditor.applyTextDelta(fileName, null);

		SVNDeltaGenerator deltaGenerator = new SVNDeltaGenerator();
		String checksum = deltaGenerator.sendDelta(fileName,
				new ByteArrayInputStream(fileContent.getBytes()),
				repositoryEditor, true);

		repositoryEditor.closeFile(fileName, checksum);

		repositoryEditor.closeDir();

		repositoryEditor.closeEdit();

	}

}
