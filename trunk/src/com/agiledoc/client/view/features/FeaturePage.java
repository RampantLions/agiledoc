package com.agiledoc.client.view.features;

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

public class FeaturePage {

	public FeaturePage(Classe classe) {

		FeaturesView.vpBodyScope.clear();

		HorizontalPanel hp = new HorizontalPanel();

		VerticalPanel vp = new VerticalPanel();
		vp.add(featureName(classe));
		vp.add(featureDescription(classe));

		if (classe.getMethods() != null) {
			vp.add(featureSteps(classe.getMethods()));
		}

		if (classe.getImports() != null) {
			vp.add(featureReferences(classe.getImports()));
		}

		hp.add(vp);
		hp.add(new FeatureViewOptions());

		FeaturesView.vpBodyScope.add(hp);
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

	public static HorizontalPanel featureDescription(final Classe classe) {

		HorizontalPanel hp = new HorizontalPanel();

		String text = null;
		if (classe.getDescription() != null
				&& !classe.getDescription().equals("")) {

			text = "<FONT SIZE=\"-1\">" + classe.getDescription() + "</FONT>";

			hp.setSpacing(20);
			hp.setWidth("600");
			hp.add(new HTML(text));
		}

		return hp;
	}

	public static Grid featureSteps(final Method[] meths) {

		Grid table = new Grid(meths.length * 3, 2);

		table.getColumnFormatter().setWidth(0, "20");

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

	public static VerticalPanel featureReferences(final String[] imports) {

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
