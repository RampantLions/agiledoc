package com.agiledoc.client.view.features;

import com.agiledoc.client.GlobalVariables;
import com.agiledoc.client.control.GetSourceClassTasks;
import com.agiledoc.shared.model.Classe;
import com.agiledoc.shared.model.Method;
import com.agiledoc.shared.util.ChangeNames;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class FeaturePage {

	/**
	 * Show the class page for the task view of the system.
	 */
	public static void show(Classe classe) {

		FeaturesView.vpBodyScope.clear();
		FeaturesView.vpBodyScope.add(showClassHeader(classe));

		if (classe.getMethods() != null) {
			FeaturesView.vpBodyScope.add(showMethods(classe.getMethods()));
		}

		if (classe.getImports() != null) {
			FeaturesView.vpBodyScope.add(showReferences(classe.getImports()));
		}
	}

	/**
	 * Show the name of the class with its package name and description.
	 */
	public static HTML showClassHeader(final Classe classe) {

		String text = "<B>" + classe.getPack().getName() + "<BR><FONT SIZE=4>"
				+ "&nbsp;&nbsp;" + classe.getName() + "</FONT></B>";

		if (classe.getDescription() != null
				&& !classe.getDescription().equals("")) {

			text += "<FONT SIZE=\"-1\"><BR><BR>"
					+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
					+ classe.getDescription() + "</FONT>";
		}

		return new HTML(text);
	}

	public static VerticalPanel showMethods(final Method[] meths) {

		VerticalPanel vp = new VerticalPanel();
		vp.setSpacing(10);

		for (Method meth : meths) {

			vp.add(new HTML("&nbsp;&nbsp;<B>" + meth.getSpacedName() + "</B>"));

			if (meth.getDescription() != null
					&& !meth.getDescription().equals("")) {

				vp.add(new HTML("&nbsp;&nbsp;&nbsp;&nbsp;"
						+ meth.getDescription()));
			}

			vp.add(new Label(" "));
		}

		return vp;
	}

	public static VerticalPanel showReferences(final String[] imports) {

		VerticalPanel links = new VerticalPanel();

		for (final String link : imports) {

			if (link.contains(GlobalVariables.getViewPath())) {

				Anchor classeAnchor = new Anchor(ChangeNames
						.getLastNameSpaced(link));
				classeAnchor.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent sender) {

						new GetSourceClassTasks(link);
					}
				});

				links.add(classeAnchor);
			}
		}

		return links;
	}

}
