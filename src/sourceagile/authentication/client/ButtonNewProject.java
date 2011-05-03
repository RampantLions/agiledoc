package sourceagile.authentication.client;

import sourceagile.client.InternationalizationConstants;
import sourceagile.shared.entities.project.Project;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.PopupPanel;

/**
 * 
 * 
 * @UserManual
 */
public class ButtonNewProject extends Anchor {

	private InternationalizationConstants internationalizationConstants = GWT
			.create(InternationalizationConstants.class);

	public static PopupPanel dialogbox = new PopupPanel();

	public ButtonNewProject() {

		this.setText(internationalizationConstants.newProject());

		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				dialogbox = new PopupPanel();
				dialogbox.add(new ProjectForm(new Project()));
				dialogbox.center();
				dialogbox.show();
			}
		});
	}
}
