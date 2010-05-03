package com.agiledoc.server.sourceClasses;

import javassist.ClassPool;
import javassist.CtClass;

public class CreateClasse {

	public CreateClasse(String root) throws Exception {

		ClassPool pool = ClassPool.getDefault();

		// ClassPath cp = new URLClassPath("www.javassist.org", 80, "/java/",
		// "org.javassist.");
		pool.insertClassPath(root);

		CtClass cc = pool.get("test.Rectangle");
		cc.setSuperclass(pool.get("test.Point"));
		cc.writeFile();
	}

}
