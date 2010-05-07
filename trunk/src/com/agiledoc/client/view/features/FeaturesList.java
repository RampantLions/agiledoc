package com.agiledoc.client.view.features;

import com.agiledoc.client.GlobalVariables;
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

		TreeItem packItem = new TreeItem();

		String packName = "";

		for (final Classe classe : GlobalVariables.getProject().getClasses()) {

			if (classe.getPack().getFullName().contains(
					GlobalVariables.getViewPath())) {

				if (!classe.getPack().getFullName().equals(packName)) {

					String itemName = ChangeNames
							.spacedName(classe.getPack().getFullName()
									.substring(
											GlobalVariables.getViewPath()
													.length() + 1));

					packItem = new TreeItem(itemName);
					packItem.setState(true);
				}

				Anchor classeAnchor = new Anchor(classe.getName());
				classeAnchor.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent sender) {

						FeaturePage.show(classe);
					}
				});

				packItem.addItem(classeAnchor);

				if (!classe.getPack().getFullName().equals(packName)) {

					packName = classe.getPack().getFullName();
					tree.addItem(packItem);
					packItem.setState(true);
				}
			}
		}

		return tree;
	}
}
