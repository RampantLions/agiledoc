package sourceagile.documentation.client.specification;

import helpagile.client.utilities.FeatureNameGenerator;
import sourceagile.documentation.client.Documentation;
import sourceagile.documentation.client.classesList.ClassesListFiltered;
import sourceagile.shared.entities.entry.ClassDocumentation;
import sourceagile.shared.entities.entry.ClassFile;
import sourceagile.userprojects.client.ProjectInitialization;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * List all the classes tagged in the current project.
 * 
 * @feature
 */
public class SpecificationList extends VerticalPanel {

	public SpecificationList(ClassFile[] entries) {

		this.add(new ClassesListFiltered(ProjectInitialization.projectEntries,
				ClassDocumentation.FEATURE_TAG));

		this.add(new ClassesListFiltered(ProjectInitialization.projectEntries,
				ClassDocumentation.ARCHITECTURE_TAG));

		this.add(new ClassesListFiltered(ProjectInitialization.projectEntries,
				ClassDocumentation.ENTITY_TAG));

	}

	public static HTML typeHeader(final String tagType) {

		HTML html = new HTML("<br><br><B><font size=3 color='darkblue'>"
				+ FeatureNameGenerator.spacedName(tagType) + "</font></B>");

		html.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent sender) {

				Documentation.documentationPanel.clear();
				Documentation.documentationPanel.add(new ClassesListFiltered(
						ProjectInitialization.projectEntries, tagType));
			}
		});

		return html;
	}

}
