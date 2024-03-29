package sourceagile.development.client.features;

import sourceagile.client.ProjectInitialization;
import sourceagile.development.client.serverCalls.GetRemoteClass;
import sourceagile.development.client.serverCalls.ListClassComments;
import sourceagile.shared.entities.entry.ClassDocumentation;
import sourceagile.shared.entities.entry.ClassFile;
import sourceagile.shared.entities.entry.Method;
import sourceagile.shared.utilities.FeatureNameGenerator;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Show the structure and the documentation of the class in a specification
 * format. Enable Stakeholders understand the "business part" only of the source
 * code.
 * 
 * TODO: Show the component and the path at the top of the description.
 * 
 * @TODO
 * @MainFeature
 */
public class FeatureDescription extends VerticalPanel {

	public static VerticalPanel vpComments = new VerticalPanel();

	public FeatureDescription(ClassFile entry) {

		if (entry.getFeature() != null) {

			this.add(featureName(entry, true));

			if (entry.getClassDoc() != null) {

				this.add(featureDescription(entry.getClassDoc()));

				if (entry.getClassDoc().getMethods() != null) {

					this.add(featureMethods(entry.getClassDoc().getMethods()));
				}

				if (entry.getClassDoc().getImports() != null) {

					this.add(featureReferences(
							entry.getClassDoc().getImports(),
							entry.getClassLocale()));
				}
			}

			this.add(featureCreation(entry));

			vpComments.setSpacing(20);

			this.add(vpComments);

			FeatureVizualizationPanel.featureContent.add(this);

			new ListClassComments(entry.toString());
		}
	}

	/**
	 * Show the name of the class with its package name and description.
	 */
	public static HTML featureName(ClassFile entry, boolean withPlanningTag) {

		String name = "<BR><BR><B><FONT SIZE=4>" + "&nbsp;&nbsp;"
				+ entry.getFeature().getFeatureName() + "</FONT></B>";

		if (withPlanningTag && entry.getClassDoc() != null
				&& entry.getClassDoc().getClassStatus() != null) {

			name += "&nbsp;&nbsp;&nbsp;<font color=blue>(Planning)</font>";
		}

		String pack = "<B>" + entry.getFeature().getFeatureFolder() + "</B>";

		HTML html = new HTML(pack + name);
		html.setWidth("400px");

		return html;
	}

	private static HorizontalPanel featureDescription(
			ClassDocumentation classDoc) {

		HorizontalPanel hp = new HorizontalPanel();

		hp.setSpacing(20);

		String text = null;
		if (classDoc.getDescription() != null
				&& !classDoc.getDescription().equals("")) {

			text = classDoc.getDescription();

		} else {

			text = " ";
		}

		hp.add(new HTML(text));

		return hp;
	}

	public static Grid featureMethods(final Method[] meths) {

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

	private static VerticalPanel featureReferences(String[] imports,
			String locale) {

		VerticalPanel vp = new VerticalPanel();

		VerticalPanel links = new VerticalPanel();

		boolean hasReference = false;

		if (imports != null) {

			for (final String link : imports) {

				final String domain = ProjectInitialization.currentProject
						.getDomain().replaceAll("/", ".");

				if (link.contains(domain)) {

					Anchor classeAnchor = new Anchor(
							FeatureNameGenerator.getLastNameSpaced(link, "\\.",
									locale));
					classeAnchor.addClickHandler(new ClickHandler() {
						public void onClick(ClickEvent sender) {

							String className = FeatureNameGenerator
									.getLastName(link, "\\.");

							String classPath = "";
							int classPathInit = domain.length() + 1;
							int classPathEnd = link.length()
									- className.length() - 1;
							if (classPathInit < classPathEnd) {

								classPath = link.substring(classPathInit,
										classPathEnd);
							}

							ClassFile entry = new ClassFile();
							entry.setFilePath(classPath.replaceAll("\\.", "/"));
							entry.setFileName(className + ".java");

							new GetRemoteClass(entry,
									OptionsIcons.OPTION_DESCRIPTION);
						}
					});

					links.add(classeAnchor);

					hasReference = true;
				}
			}
		}

		if (hasReference) {

			vp.add(new Label("See also:"));
		}

		vp.add(links);

		return vp;
	}

	private static VerticalPanel featureCreation(ClassFile entry) {

		VerticalPanel vp = new VerticalPanel();

		String userName = null;
		if (entry.getUser() != null) {

			userName = entry.getUser().getName();
		}

		String creation = "<br><br><font size=1>Created: "
				+ entry.getDateModified() + " &nbsp; by " + userName
				+ "</font>";

		vp.add(new HTML(creation));

		return vp;
	}

}
