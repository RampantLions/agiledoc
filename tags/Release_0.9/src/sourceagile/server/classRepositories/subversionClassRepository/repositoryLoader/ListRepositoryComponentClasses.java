package sourceagile.server.classRepositories.subversionClassRepository.repositoryLoader;

import java.io.IOException;
import java.util.HashMap;

import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.io.SVNRepository;

import sourceagile.shared.entities.entry.ClassFile;

public class ListRepositoryComponentClasses {

	public static HashMap<String, ClassFile> listRepositoryComponentFiles(
			SVNRepository repository, String componentPath, String locale)
			throws SVNException, IOException {

		HashMap<String, ClassFile> classesMap = new HashMap<String, ClassFile>();

		ListRepositoryClasses.listRepositoryFolder(repository, componentPath,
				locale, classesMap);

		for (ClassFile classFile : classesMap.values()) {

			GetRepositoryClass.getClassFile(repository, classFile);

			GetRepositoryClass.setEntryFeature(classFile);

			classesMap.put(classFile.toString(), classFile);
		}

		return classesMap;
	}

}
