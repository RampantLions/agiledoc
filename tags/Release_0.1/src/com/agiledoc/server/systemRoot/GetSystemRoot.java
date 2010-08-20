package com.agiledoc.server.systemRoot;

import java.io.File;

import com.agiledoc.shared.model.Project;
import com.sun.javadoc.RootDoc;

public class GetSystemRoot {

	public static RootDoc GetRootDoc(Project proj) {

		EasyDoclet doclet = new EasyDoclet(new File(proj.getRoot()), proj
				.getDomain());

		return doclet.getRootDoc();
	}

}
