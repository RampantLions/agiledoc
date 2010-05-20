package com.agiledoc.client.view.help;

import com.agiledoc.client.GlobalVariables;
import com.agiledoc.client.control.GetFeatureClass;
import com.agiledoc.shared.model.Classe;
import com.agiledoc.shared.model.Method;
import com.agiledoc.shared.util.ChangeNames;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class FeaturePage extends VerticalPanel {

	public FeaturePage(Classe classe) {

		setWidth("700");
		
		add(featureName(classe));
		add(featureDescription(classe));

		if (classe.getClasseDoc().getMethods() != null) {
			add(featureSteps(classe.getClasseDoc().getMethods()));
		}

		if (classe.getClasseDoc().getImports() != null) {
			add(featureReferences(classe.getClasseDoc().getImports()));
		}

	}

	/**
	 * Show the name of the class with its package name and description.
	 */
	public static HTML featureName(final Classe classe) {

		String pack = "";

		String name = "<BR><BR><B><FONT SIZE=4>" + "&nbsp;&nbsp;"
				+ classe.getName() + "</FONT></B>";

		if (!classe.getPack().getFullName().equals(
				GlobalVariables.getProject().getFeatureFullPackage())) {

			pack = "<B>" + classe.getPack().getName() + "</B>";
		}

		return new HTML(pack + name);
	}

	private static HorizontalPanel featureDescription(final Classe classe) {

		HorizontalPanel hp = new HorizontalPanel();

		String text = null;
		if (classe.getClasseDoc().getDescription() != null
				&& !classe.getClasseDoc().getDescription().equals("")) {

			text = "<FONT SIZE=\"-1\">"
					+ classe.getClasseDoc().getDescription() + "</FONT>";

			hp.setSpacing(20);
			hp.setWidth("600");
			hp.add(new HTML(text));
		}

		return hp;
	}

	private static Grid featureSteps(final Method[] meths) {

		Grid table = new Grid(meths.length * 3, 2);

		table.getColumnFormatter().setWidth(0, "40");

		for (int i = 0; i < meths.length; i++) {

			Method meth = meths[i];

			table.setWidget((i * 3), 1, new HTML("<B>" + meth.getSpacedName()
					+ "</B>"));

			if (meth.getDescription() != null
					&& !meth.getDescription().equals("")) {

				table
						.setWidget((i * 3 + 1), 1, new HTML(meth
								.getDescription()));
			}

			table.setWidget((i * 3 + 2), 0, new Label(" "));
		}

		return table;
	}

	private static VerticalPanel featureReferences(final String[] imports) {

		VerticalPanel vp = new VerticalPanel();

		VerticalPanel links = new VerticalPanel();

		boolean hasReference = false;

		for (final String link : imports) {

			if (link.contains(GlobalVariables.getProject()
					.getFeatureFullPackage())) {

				Anchor classeAnchor = new Anchor(ChangeNames
						.getLastNameSpaced(link));
				classeAnchor.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent sender) {

						new GetFeatureClass(link);
					}
				});

				links.add(classeAnchor);

				hasReference = true;
			}
		}

		if (hasReference) {

			vp.add(new Label("See also:"));
		}

		vp.add(links);

		return vp;
	}

}
