package com.agiledoc.client.view.help;

import com.agiledoc.client.GlobalVariables;
import com.agiledoc.shared.model.Classe;
import com.agiledoc.shared.util.ChangeNames;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;

/**
 * A menu list with all the classes defined inside the features package of the
 * project.
 */
public class FeaturesList extends Tree {

	public static Classe initialClass = new Classe();

	public FeaturesList() {

		initialClass = mainItems(this);

		subItems(this);

	}

	public static Classe mainItems(Tree tree) {

		Classe initialClass = null;

		for (final Classe classe : GlobalVariables.getProject().getClasses()) {

			if (classe.getPack().getFullName().equals(
					GlobalVariables.getProject().getFeatureFullPackage())) {

				Anchor classeAnchor = new Anchor(classe.getName());
				classeAnchor.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent sender) {

						HelpView.showFeature(new FeaturePage(classe), classe);
					}
				});

				tree.addItem(classeAnchor);

				if (initialClass == null) {

					initialClass = classe;
				}
			}
		}

		return initialClass;
	}

	private static void subItems(Tree tree) {

		String packName = "";
		TreeItem packItem = new TreeItem();

		for (final Classe classe : GlobalVariables.getProject().getClasses()) {

			if (classe.getPack().getFullName().contains(
					GlobalVariables.getProject().getFeatureFullPackage())
					&& !classe.getPack().getFullName().equals(
							GlobalVariables.getProject()
									.getFeatureFullPackage())) {

				Anchor classeAnchor = new Anchor(classe.getName());
				classeAnchor.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent sender) {

						HelpView.showFeature(new FeaturePage(classe), classe);
					}
				});

				if (!classe.getPack().getFullName().equals(packName)) {

					String itemName = ChangeNames
							.spacedName(classe.getPack().getFullName()
									.substring(
											GlobalVariables.getProject()
													.getFeatureFullPackage()
													.length() + 1));

					packItem = new TreeItem("<BR>" + itemName);
					packItem.setState(true);
				}

				packItem.addItem(classeAnchor);

				if (!classe.getPack().getFullName().equals(packName)) {

					packName = classe.getPack().getFullName();
					tree.addItem(packItem);
					packItem.setState(true);
				}
			}

			if (initialClass == null) {

				initialClass = classe;
			}
		}
	}
}