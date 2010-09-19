package sourceagile.client.features.featureOptions;

import sourceagile.client.project.ProjectInitialization;
import sourceagile.client.serverConnection.GetRemoteClass;
import sourceagile.shared.ClassDocumentation;
import sourceagile.shared.Entry;
import sourceagile.shared.Feature;
import sourceagile.shared.Method;
import sourceagile.shared.utilities.FeatureNameGenerator;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
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

		add(featureReferences(entry.getClassDoc().getImports()));

		add(featureCreation(entry));

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

	private static VerticalPanel featureReferences(String[] imports) {

		VerticalPanel vp = new VerticalPanel();

		VerticalPanel links = new VerticalPanel();

		boolean hasReference = false;

		for (final String link : imports) {

			final String domain = ProjectInitialization.currentProject
					.getDomain().replaceAll("/", ".");

			if (link.contains(domain)) {

				Anchor classeAnchor = new Anchor(
						FeatureNameGenerator.getLastNameSpaced(link, "\\."));
				classeAnchor.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent sender) {

						String className = FeatureNameGenerator.getLastName(
								link, "\\.");

						String classPath = "";
						int classPathInit = domain.length() + 1;
						int classPathEnd = link.length() - className.length()
								- 1;
						if (classPathInit < classPathEnd) {

							classPath = link.substring(classPathInit,
									classPathEnd);
						}

						Entry entry = new Entry();
						entry.setClassPath(classPath.replaceAll("\\.", "/"));
						entry.setClassName(className + ".java");

						new GetRemoteClass(entry,
								OptionsIcons.optionDescription);
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

	private static VerticalPanel featureCreation(Entry entry) {

		VerticalPanel vp = new VerticalPanel();

		String creation = "<br><br><font size=1>Created: "
				+ entry.getDateModified() + " &nbsp; by "
				+ entry.getUser().getName() + "</font>";

		vp.add(new HTML(creation));

		return vp;
	}

}
