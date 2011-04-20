package sourceagile.documentation.client.documentationMenu;

import sourceagile.client.InternationalizationConstants;
import sourceagile.documentation.client.Documentation;
import sourceagile.documentation.client.ListTaggedClasses;
import sourceagile.shared.entities.entry.ClassDocumentation;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HTML;

/**
 * 
 * @UserManual
 */
public class RequirementsListLink extends HTML {

	private static InternationalizationConstants internationalizationConstants = GWT
			.create(InternationalizationConstants.class);

	public static final String textUnpressed = "<a href='#'>"
			+ internationalizationConstants.requirementsList() + "</a>";
	public static final String textPressed = "<a href='#'><font color=orange><b>"
			+ internationalizationConstants.requirementsList()
			+ "</b></font></a>";

	public RequirementsListLink() {

		this.setHTML(textUnpressed);
		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				Documentation.untoggleLinks();
				Documentation.requirementsListLink.setHTML(textPressed);

				Documentation.documentationPanel.clear();
				Documentation.documentationPanel.add(new ListTaggedClasses(
						ClassDocumentation.REQUIREMENT_TAG));
			}
		});

	}
}
