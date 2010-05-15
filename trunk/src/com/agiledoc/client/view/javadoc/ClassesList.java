package com.agiledoc.client.view.javadoc;

import com.agiledoc.client.GlobalVariables;
import com.agiledoc.shared.model.Classe;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ClassesList {

	public static ScrollPanel getClassesPanel(String pack) {

		VerticalPanel vp = new VerticalPanel();

		for (final Classe classe : GlobalVariables.getProject().getClasses()) {

			if (pack == null || classe.getPack().getFullName().equals(pack)) {

				Anchor classeAnchor = new Anchor(classe.getClasseDoc()
						.getFullName());
				classeAnchor.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent sender) {

						JavadocView.vpBodyJavadoc.add(new JavadocClassPage(
								classe));
					}
				});

				vp.add(classeAnchor);
			}
		}

		ScrollPanel spClasses = new ScrollPanel(vp);
		spClasses.setHeight("400");
		spClasses.setAlwaysShowScrollBars(true);

		return spClasses;
	}
}
