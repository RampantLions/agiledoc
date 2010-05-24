package com.agiledoc.server.sourceClasses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.agiledoc.server.systemRoot.GetSystemRoot;
import com.agiledoc.shared.model.Classe;
import com.agiledoc.shared.model.Project;
import com.agiledoc.shared.model.Tag;
import com.agiledoc.shared.model.TodoClasse;
import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.RootDoc;

public class ListSourceClasses {

	private static List<Classe> featuresMainItems;
	private static List<Classe> featuresSubItems;
	private static List<TodoClasse> todoList;

	public static Project ListClasses(Project proj) {

		RootDoc rootDoc = GetSystemRoot.GetRootDoc(proj);

		ClassDoc[] classesDoc = rootDoc.classes();

		Classe[] classes = new Classe[classesDoc.length];

		featuresMainItems = new ArrayList<Classe>();
		featuresSubItems = new ArrayList<Classe>();
		todoList = new ArrayList<TodoClasse>();

		for (int i = 0; i < classesDoc.length; ++i) {

			classes[i] = GetClasse.createClasse(proj, classesDoc[i]);

			listFeatures(proj, classes[i]);

			if (Tag.TODO.equals(classes[i].getTask())) {

				TodoClasse todoClasse = new TodoClasse();
				todoClasse.setClasse(classes[i]);

				todoList.add(todoClasse);
			}
		}

		Collections.sort(todoList);

		featuresMainItems.addAll(featuresSubItems);

		proj.setClasses(classes);
		proj.setTodoList(todoList);
		proj.setFeatures(featuresMainItems);

		return proj;
	}

	private static void listFeatures(Project proj, Classe classe) {

		if (classe.getPack().getFullName().equals(proj.getFeatureFullPackage())) {

			featuresMainItems.add(classe);

		} else if (classe.getPack().getFullName().contains(
				proj.getFeatureFullPackage())) {

			featuresSubItems.add(classe);
		}
	}

}
