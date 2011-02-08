package sourceagile.documentation.client.documentationMenu;

import sourceagile.documentation.client.Documentation;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;

/**
 * 
 * @TODO
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

				Documentation.untoggleLinks();
				Documentation.relatedLinksLink.setHTML(textPressed);
			}
		});
	}
}
