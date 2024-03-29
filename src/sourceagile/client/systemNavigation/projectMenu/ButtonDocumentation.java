package sourceagile.client.systemNavigation.projectMenu;

import sourceagile.client.InternationalizationConstants;
import sourceagile.documentation.client.Documentation;

import com.google.gwt.core.client.GWT;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;

/**
 * 
 * @UserManual
 */
public class ButtonDocumentation extends Button {

	private static InternationalizationConstants internationalizationConstants = GWT
			.create(InternationalizationConstants.class);

	public ButtonDocumentation() {

		this.setText(internationalizationConstants.documentation());

		this.addListener(new ButtonListenerAdapter() {
			@Override
			public void onClick(Button button, EventObject e) {

				ProjectMenu.untoggleButtons();
				ProjectMenu.buttonDocumentation.toggle(true);

				new Documentation();
			}
		});
	}

}
