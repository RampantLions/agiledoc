package sourceagile.documentation.client.documentationMenu;

import sourceagile.client.InternationalizationConstants;
import sourceagile.documentation.client.Documentation;
import sourceagile.documentation.client.projectDescription.ProjectDescription;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;

/**
 * 
 * @UserManual
 */
public class ProjectDescriptionLink extends Anchor {

	private static InternationalizationConstants internationalizationConstants = GWT
			.create(InternationalizationConstants.class);

	public ProjectDescriptionLink() {

		this.setText(internationalizationConstants.projectDescription());
		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				Documentation.documentationPanel.clear();
				Documentation.documentationPanel.add(new ProjectDescription());
			}
		});

	}
}
