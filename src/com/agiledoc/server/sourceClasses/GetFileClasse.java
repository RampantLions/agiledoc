package com.agiledoc.server.sourceClasses;

import java.io.File;
import java.util.Date;

import com.agiledoc.shared.model.Classe;

/**
 * @task
 */
public class GetFileClasse {

	public static File getFile(String root, Classe classe) {

		String className = classe.getFullName();

		if (classe.getClassName().indexOf('.') != -1) {

			className = classe.getFullName().substring(
					0,
					classe.getFullName().length()
							- classe.getClassName().indexOf('.'));
		}

		String fileName = root + "/" + className.replace('.', '/') + ".java";

		return new File(fileName);

	}

	public static Date getLastModified(String root, Classe classe) {

		File file = getFile(root, classe);

		Date date = null;

		if (file.exists()) {
			date = new Date(file.lastModified());
		}

		return date;
	}

}
