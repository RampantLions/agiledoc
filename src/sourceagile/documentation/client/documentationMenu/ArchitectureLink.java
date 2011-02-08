package sourceagile.documentation.client.documentationMenu;

import sourceagile.documentation.client.Documentation;
import sourceagile.documentation.client.ListTaggedClasses;
import sourceagile.shared.entities.entry.ClassDocumentation;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;

/**
 * 
 * @UserManual
 */
public class ArchitectureLink extends Anchor {

	public static final String textUnpressed = "Architecture";
	public static final String textPressed = "<font color=orange><b>Architecture</b></font>";

	public ArchitectureLink() {

		this.setHTML(textUnpressed);
		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				Documentation.untoggleLinks();
				Documentation.architectureLink.setHTML(textPressed);

				Documentation.documentationPanel.clear();
				Documentation.documentationPanel.add(new ListTaggedClasses(
						ClassDocumentation.ARCHITECTURE_TAG));
			}
		});

	}
}
