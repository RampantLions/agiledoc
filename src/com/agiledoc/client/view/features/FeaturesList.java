package com.agiledoc.client.view.features;

import com.agiledoc.client.GlobalVariables;
import com.agiledoc.client.control.GetSourceClassTasks;
import com.agiledoc.shared.model.Classe;
import com.agiledoc.shared.util.ChangeNames;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;

public class FeaturesList {

	public static Tree createMenu() {

		Tree tree = new Tree();

		String initialClass = addMainItems(tree);

		new GetSourceClassTasks(initialClass);

		addTreeItems(tree);

		return tree;
	}

	public static String addMainItems(Tree tree) {

		String initialClass = null;

		for (final Classe classe : GlobalVariables.getProject().getClasses()) {

			if (classe.getPack().getFullName().equals(
					GlobalVariables.getViewPath())) {

				Anchor classeAnchor = new Anchor(classe.getName());
				classeAnchor.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent sender) {

						FeaturePage.show(classe);
					}
				});

				tree.addItem(classeAnchor);

				if (initialClass == null) {

					initialClass = classe.getFullName();
				}
			}
		}

		return initialClass;
	}

	private static void addTreeItems(Tree tree) {

		String packName = "";
		TreeItem packItem = new TreeItem();

		for (final Classe classe : GlobalVariables.getProject().getClasses()) {

			if (classe.getPack().getFullName().contains(
					GlobalVariables.getViewPath())
					&& !classe.getPack().getFullName().equals(
							GlobalVariables.getViewPath())) {

				Anchor classeAnchor = new Anchor(classe.getName());
				classeAnchor.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent sender) {

						FeaturePage.show(classe);
					}
				});

				if (!classe.getPack().getFullName().equals(packName)) {

					String itemName = ChangeNames
							.spacedName(classe.getPack().getFullName()
									.substring(
											GlobalVariables.getViewPath()
													.length() + 1));

					packItem = new TreeItem(itemName);
					packItem.setState(true);
				}

				packItem.addItem(classeAnchor);

				if (!classe.getPack().getFullName().equals(packName)) {

					packName = classe.getPack().getFullName();
					tree.addItem(packItem);
					packItem.setState(true);
				}
			}
		}
	}
}
