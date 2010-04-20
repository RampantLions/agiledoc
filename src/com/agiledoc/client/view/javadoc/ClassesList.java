package com.agiledoc.client.view.javadoc;

import com.agiledoc.client.GlobalVariables;
import com.agiledoc.shared.model.Classe;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * @userTask
 * 
 * @author allineo
 * @modified 04/08/2010
 */
public class ClassesList {

	/**
	 * @author allineo
	 * @modified 04/08/2010
	 */
	public static ScrollPanel getClassesPanel(String pack) {

		VerticalPanel vp = new VerticalPanel();

		for (final Classe classe : GlobalVariables.getCLASSES_LIST()) {

			if (pack == null || classe.getPack().getFullName().equals(pack)) {

				Anchor classeAnchor = new Anchor(classe.getFullName());
				classeAnchor.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent sender) {

						new ClassPage(classe);
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
