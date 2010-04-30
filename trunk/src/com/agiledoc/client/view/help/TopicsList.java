package com.agiledoc.client.view.help;

import com.agiledoc.client.GlobalVariables;
import com.agiledoc.shared.model.Classe;
import com.agiledoc.shared.model.Tag;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;

public class TopicsList {

	public static Tree createHelpMenu() {

		Tree tree = new Tree();
		TreeItem packItem = new TreeItem();
		String packName = "";

		for (final Classe classe : GlobalVariables.getProject().getClasses()) {

			if (Tag.USER_TASK.equals(classe.getTask())) {

				if (!classe.getPack().getFullName().equals(packName)) {

					packItem = new TreeItem(new HTML("<B>"
							+ classe.getPack().getName() + "</B>"));

					packItem.setState(true);
				}

				Anchor classeAnchor = new Anchor(classe.getName());
				classeAnchor.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent sender) {

						TopicPage.showHelpTopic(classe);
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
