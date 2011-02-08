package sourceagile.documentation.client.documentationMenu;

import sourceagile.documentation.client.Documentation;
import sourceagile.documentation.client.project.RelatedLinks;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;

/**
 * 
 * @UserManual
 */
public class RelatedLinksLink extends Anchor {

	public static final String textUnpressed = "Related Links";
	public static final String textPressed = "<font color=orange><b>Related Links</b></font>";

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
