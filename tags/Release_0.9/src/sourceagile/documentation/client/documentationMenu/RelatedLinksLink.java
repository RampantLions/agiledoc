package sourceagile.documentation.client.documentationMenu;

import sourceagile.client.InternationalizationConstants;
import sourceagile.documentation.client.Documentation;
import sourceagile.documentation.client.project.RelatedLinks;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HTML;

/**
 * 
 * @UserManual
 */
public class RelatedLinksLink extends HTML {

	private static InternationalizationConstants internationalizationConstants = GWT
			.create(InternationalizationConstants.class);

	public static final String textUnpressed = "<a href='#'>"
			+ internationalizationConstants.relatedLinks() + "</a>";
	public static final String textPressed = "<a href='#'><font color=orange><b>"
			+ internationalizationConstants.relatedLinks() + "</b></font></a>";

	public RelatedLinksLink() {

		this.setHTML(textUnpressed);
		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				Documentation.documentationPanel.clear();
				Documentation.documentationPanel.add(new RelatedLinks());
			}
		});
	}
}
