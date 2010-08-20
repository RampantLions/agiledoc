package com.agiledoc.client.view.javadoc;

import com.agiledoc.client.GlobalVariables;
import com.agiledoc.shared.model.Classe;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class PacksList {

	public static ScrollPanel getPacksPanel() {

		VerticalPanel vp = new VerticalPanel();
		vp.setSize("100%", "100%");
		vp.setSpacing(5);
		
		String pacName = "";

		for (Classe classe : GlobalVariables.getProject().getClasses()) {

			final String fullName = classe.getPack().getFullName();

			if (!pacName.equals(fullName)) {

				Anchor pack = new Anchor(fullName);
				pack.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent sender) {

						JavadocView.vpClassesJavadoc.clear();
						JavadocView.vpClassesJavadoc.add(ClassesList
								.getClassesPanel(fullName));
					}
				});

				vp.add(pack);

				pacName = fullName;
			}
		}

		ScrollPanel spPacks = new ScrollPanel(vp);
		spPacks.setHeight("200");
		spPacks.setAlwaysShowScrollBars(true);

		return spPacks;
	}
}
