package sourceagile.client.features.featureOptions;

import sourceagile.shared.ClassDocumentation;
import sourceagile.shared.Entry;
import sourceagile.shared.Feature;
import sourceagile.shared.Method;

import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class FeatureDescription extends VerticalPanel {

	public FeatureDescription(Entry entry) {

		FeatureContentPanel.featureContent.clear();

		add(featureName(entry.getFeature()));

		add(featureDescription(entry.getClassDoc()));

		add(featureSteps(entry.getClassDoc().getMethods()));

		FeatureContentPanel.featureContent.add(this);
	}

	/**
	 * Show the name of the class with its package name and description.
	 */
	public static HTML featureName(Feature feature) {

		String name = "<BR><BR><B><FONT SIZE=4>" + "&nbsp;&nbsp;"
				+ feature.getFeatureName() + "</FONT></B>";

		String pack = "<B>" + feature.getFeatureFolder() + "</B>";

		HTML html = new HTML(pack + name);

		return html;
	}

	private static HorizontalPanel featureDescription(
			ClassDocumentation classDoc) {

		HorizontalPanel hp = new HorizontalPanel();

		hp.setSpacing(20);

		String text = null;
		if (classDoc.getDescription() != null
				&& !classDoc.getDescription().equals("")) {

			text = "<FONT SIZE=\"-1\">" + classDoc.getDescription() + "</FONT>";

		} else {

			text = " ";
		}

		hp.add(new HTML(text));

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

				table.setWidget((i * 3 + 1), 1, new HTML(meth.getDescription()));
			}

			table.setWidget((i * 3 + 2), 0, new Label(" "));
		}

		return table;
	}
}
