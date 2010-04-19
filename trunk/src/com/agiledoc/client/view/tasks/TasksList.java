package com.agiledoc.client.view.tasks;

import com.agiledoc.client.GlobalVariables;
import com.agiledoc.shared.model.Classe;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;

/**
 * @userTask
 * 
 * @author allineo
 * @modified 04/15/2010
 */
public class TasksList {

	/**
	 * Create and show the tasks menu, based on the classes listed.
	 * 
	 * @author allineo
	 * @modified 04/15/2010
	 */
	public static Tree createMenu() {

		Tree tree = new Tree();

		TreeItem packItem = new TreeItem();

		String packName = "";

		for (final Classe classe : GlobalVariables.getCLASSES_LIST()) {

			if (classe.getTask() != null) {

				if (!classe.getPack().getFullName().equals(packName)) {

					String itemName = classe.getPack().getFullName().substring(
							GlobalVariables.getPACK().length() + 1);

					packItem = new TreeItem(itemName);
					packItem.setState(true);
				}

				Anchor classeAnchor = new Anchor(classe.getName());
				classeAnchor.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent sender) {

					//	TaskPage.show(classe);
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
