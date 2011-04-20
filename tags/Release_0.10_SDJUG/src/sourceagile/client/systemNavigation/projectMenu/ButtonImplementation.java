package sourceagile.client.systemNavigation.projectMenu;

import sourceagile.client.InternationalizationConstants;
import sourceagile.development.client.Development;
import sourceagile.development.client.features.OptionsIcons;

import com.google.gwt.core.client.GWT;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;

/**
 * 
 * @UserManual
 */
public class ButtonImplementation extends Button {

	private static InternationalizationConstants internationalizationConstants = GWT
			.create(InternationalizationConstants.class);

	public ButtonImplementation() {

		this.setText(internationalizationConstants.implementation());

		this.addListener(new ButtonListenerAdapter() {

			@Override
			public void onClick(Button button, EventObject e) {

				ProjectMenu.untoggleButtons();
				ProjectMenu.buttonDevelopment.toggle(true);

				new Development(OptionsIcons.OPTION_REQUIREMENTS);
			}
		});
	}

}
