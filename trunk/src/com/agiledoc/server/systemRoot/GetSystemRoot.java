package com.agiledoc.server.systemRoot;

import java.io.File;

import com.sun.javadoc.RootDoc;

/**
 * @task
 */
public class GetSystemRoot {

	public static RootDoc GetRootDoc(String root, String pack) {

		EasyDoclet doclet = new EasyDoclet(new File(root), pack);

		return doclet.getRootDoc();
	}

}
