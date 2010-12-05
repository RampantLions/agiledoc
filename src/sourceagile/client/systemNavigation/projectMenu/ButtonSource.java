package sourceagile.client.systemNavigation.projectMenu;

import sourceagile.client.InternationalizationConstants;
import sourceagile.development.client.Development;
import sourceagile.development.client.features.OptionsIcons;

import com.google.gwt.core.client.GWT;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;

public class ButtonSource extends Button {

	private static InternationalizationConstants internationalizationConstants = GWT
			.create(InternationalizationConstants.class);

	public ButtonSource() {

		this.setText(internationalizationConstants.source());

		this.addListener(new ButtonListenerAdapter() {
			@Override
			public void onClick(Button button, EventObject e) {

				new Development(null, OptionsIcons.OPTION_SOURCE);
			}
		});
	}

}
