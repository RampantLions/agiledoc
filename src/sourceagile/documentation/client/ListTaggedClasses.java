package sourceagile.documentation.client;

import sourceagile.client.ProjectInitialization;
import sourceagile.development.client.Development;
import sourceagile.development.client.features.OptionsIcons;
import sourceagile.shared.entities.entry.ClassDocumentation;
import sourceagile.shared.entities.entry.ClassFile;
import sourceagile.shared.entities.project.ProjectComponents;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Show the list of classes from the source code that are selected with a
 * specific tag. Enable people to identify important parts of a software like
 * Requirements, Architecture, Entity model, etc.
 * 
 * @MainFeature
 */
public class ListTaggedClasses extends VerticalPanel {

	public ListTaggedClasses(String tagType) {

		this.setWidth("700px");

		for (ProjectComponents projectComponent : ProjectInitialization.currentProject
				.getProjectComponents()) {

			VerticalPanel vp = new VerticalPanel();
			vp.setSpacing(20);

			HTML htmlComponentName = new HTML(
					"<br><br><B><font size=3 color='darkblue'>"
							+ projectComponent.getComponentName()
							+ "</font></B>");

			boolean showComponent = false;

			for (final ClassFile entry : ProjectInitialization.projectEntries
					.values()) {

				if (projectComponent.getComponentPath() != null
						&& entry.getFilePath().startsWith(
								projectComponent.getComponentPath())) {

					if (entry.getClassDoc() != null
							&& entry.getClassDoc().getTagType() != null) {

						if ((!ClassDocumentation.FEATURE_TAG
								.equals(tagType) && entry.getClassDoc()
								.getTagType().equals(tagType))
								|| (ClassDocumentation.FEATURE_TAG
										.equals(tagType) && (entry
										.getClassDoc()
										.getTagType()
										.equals(ClassDocumentation.MAIN_FEATURE_TAG) || entry
										.getClassDoc()
										.getTagType()
										.equals(ClassDocumentation.FEATURE_TAG)))) {

							String name = "<br><B>"
									+ entry.getFeature().getFeatureName()
									+ "</B> ";

							if (entry.getClassDoc().getClassStatus() != null) {

								name += "&nbsp;&nbsp;&nbsp;<font color=blue>(Planning)</font>";
							}

							String description = "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
									+ entry.getClassDoc().getDescription();

							HTML html = new HTML(name + description);

							html.addClickHandler(new ClickHandler() {
								public void onClick(ClickEvent sender) {

									new Development(entry,
											OptionsIcons.OPTION_DESCRIPTION);
								}
							});

							vp.add(html);

							showComponent = true;
						}
					}
				}
			}

			if (showComponent) {

				if (!ClassDocumentation.MAIN_FEATURE_TAG.equals(tagType)) {

					this.add(htmlComponentName);
				}

				this.add(vp);
			}
		}
	}
}
