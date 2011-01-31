package sourceagile.documentation.client.documentationMenu;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;

/**
 * 
 * @TODO
 * @UserManual
 */
public class RelatedLinksLink extends Anchor {

	public RelatedLinksLink() {

		this.setText("Related Links");
		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

			}
		});

	}
}
