package sourceagile.client.systemNavigation.projectMenu;

import sourceagile.client.InternationalizationConstants;

import com.google.gwt.core.client.GWT;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;

public class ButtonDiagnosis extends Button {

	private static InternationalizationConstants internationalizationConstants = GWT
			.create(InternationalizationConstants.class);

	public ButtonDiagnosis() {

		this.setText(internationalizationConstants.diagnosis());

		this.addListener(new ButtonListenerAdapter() {
			@Override
			public void onClick(Button button, EventObject e) {

			}
		});
	}

}