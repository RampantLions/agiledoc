package sourceagile.documentation.client.documentationMenu;

import sourceagile.client.InternationalizationConstants;
import sourceagile.documentation.client.Documentation;
import sourceagile.documentation.client.project.ProjectDescription;

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

	public static final String textUnpressed = internationalizationConstants
			.projectDescription();
	public static final String textPressed = "<font color=orange><b>"
			+ internationalizationConstants.projectDescription()
			+ "</b></font>";

	public ProjectDescriptionLink() {

		this.setHTML(textUnpressed);
		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				Documentation.documentationPanel.clear();
				Documentation.documentationPanel.add(new ProjectDescription());
			}
		});

	}
}
