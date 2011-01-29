package sourceagile.documentation.client;

import sourceagile.client.ProjectInitialization;
import sourceagile.shared.entities.entry.ClassFile;
import sourceagile.shared.entities.project.ProjectComponents;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * 
 * @Feature
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

			for (final ClassFile entry : ProjectInitialization.projectEntries) {

				if (projectComponent.getComponentPath() != null
						&& entry.getFilePath().startsWith(
								projectComponent.getComponentPath())) {

					if (entry.getClassDoc() != null
							&& entry.getClassDoc().getTagType() != null
							&& entry.getClassDoc().getTagType().equals(tagType)) {

						String name = "<br><B>"
								+ entry.getFeature().getFeatureName() + "</B> ";

						String description = "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
								+ entry.getClassDoc().getDescription();

						HTML html = new HTML(name + description);

						html.addClickHandler(new ClickHandler() {
							public void onClick(ClickEvent sender) {

							}
						});

						vp.add(html);

						showComponent = true;
					}
				}
			}

			if (showComponent) {

				this.add(htmlComponentName);

				this.add(vp);
			}
		}
	}
}
