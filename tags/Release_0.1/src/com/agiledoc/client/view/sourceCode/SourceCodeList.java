package com.agiledoc.client.view.sourceCode;

import com.agiledoc.client.GlobalVariables;
import com.agiledoc.client.logic.GetSourceCode;
import com.agiledoc.shared.model.Classe;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;

/**
 * A menu list with all the classes defined inside the features package of the
 * project.
 */
public class SourceCodeList extends Tree {

	public SourceCodeList() {

		String packName = "";
		TreeItem packItem = new TreeItem();

		for (final Classe classe : GlobalVariables.getProject().getClasses()) {

			if (classe.getPack().getFullName().contains(
					GlobalVariables.getProject().getFeatureFullPackage())
					&& !classe.getPack().getFullName().equals(
							GlobalVariables.getProject()
									.getFeatureFullPackage())) {

				Anchor classeAnchor = new Anchor(classe.getClasseDoc()
						.getClassName());
				classeAnchor.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent sender) {

						new GetSourceCode(classe, SourceCodeView.vpBody);
					}
				});

				if (!classe.getPack().getFullName().equals(packName)) {

					String itemName = classe.getPack().getFullName();

					packItem = new TreeItem("<BR>" + itemName);
					packItem.setState(true);
				}

				packItem.addItem(classeAnchor);

				if (!classe.getPack().getFullName().equals(packName)) {

					packName = classe.getPack().getFullName();
					addItem(packItem);
					packItem.setState(true);
				}
			}
		}
	}
}
