package sourceagile.client.systemNavigation.projectMenu;

import sourceagile.client.InternationalizationConstants;

import com.google.gwt.core.client.GWT;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;

/**
 * 
 * @UserManual
 */
public class ButtonDevelopment extends Button {

	private static InternationalizationConstants internationalizationConstants = GWT
			.create(InternationalizationConstants.class);

	public ButtonDevelopment() {

		this.setText(internationalizationConstants.development());

		this.addListener(new ButtonListenerAdapter() {

			@Override
			public void onClick(Button button, EventObject e) {

				ProjectMenu.untoggleButtons();
				ProjectMenu.buttonDevelopment.toggle(true);

				// new Development(OptionsIcons.OPTION_ALLCLASSES);
			}
		});
	}

}
