package sourceagile.server.classRepositories.subversionClassRepository.repositoryLoader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.io.SVNRepository;

import sourceagile.shared.entities.entry.ClassFile;

public class ListRepositoryComponentClasses {

	public static HashMap<String, ClassFile> listRepositoryComponentFiles(
			SVNRepository repository, String componentPath)
			throws SVNException, IOException {

		List<ClassFile> entriesList = ListRepositoryClasses
				.listRepositoryFolder(repository, componentPath,
						new ArrayList<ClassFile>());

		HashMap<String, ClassFile> classesMap = new HashMap<String, ClassFile>();

		for (ClassFile classFile : entriesList) {

			GetRepositoryClass.getClassFile(repository, classFile);

			GetRepositoryClass.setEntryFeature(classFile);

			classesMap.put(classFile.toString(), classFile);
		}

		return classesMap;
	}

}
