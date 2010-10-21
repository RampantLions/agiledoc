package sourceagile.client.systemNavigation.projectMenu;

import com.gwtext.client.core.EventObject;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;

public class ButtonDiagnosis extends Button {

	public ButtonDiagnosis() {

		this.setText("Diagnosis");

		this.addListener(new ButtonListenerAdapter() {
			@Override
			public void onClick(Button button, EventObject e) {

			}
		});
	}

}
