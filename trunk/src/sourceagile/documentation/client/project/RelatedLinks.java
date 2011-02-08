package sourceagile.documentation.client.project;

import sourceagile.client.ProjectInitialization;
import sourceagile.documentation.client.Documentation;
import sourceagile.documentation.client.documentationMenu.RelatedLinksLink;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * 
 * @UserManual
 */
public class RelatedLinks extends VerticalPanel {

	public RelatedLinks() {

		Documentation.untoggleLinks();
		Documentation.relatedLinksLink.setHTML(RelatedLinksLink.textPressed);

		this.setSpacing(40);

		HTML relatedLinksText = new HTML(
				ProjectInitialization.currentProject.getRelatedLinks());

		this.add(relatedLinksText);

		this.add(buttonEdit());

	}

	private Button buttonEdit() {

		Button button = new Button("Edit", new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				Documentation.documentationPanel.clear();
				Documentation.documentationPanel.add(new RelatedLinksEdit());
			}
		});

		return button;
	}

}
