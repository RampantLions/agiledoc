package sourceagile.client.systemNavigation.projectMenu;

import sourceagile.documentation.client.Documentation;

import com.gwtext.client.core.EventObject;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;

public class ButtonDocumentation extends Button {

	public ButtonDocumentation() {

		this.setText("Documentation");

		this.addListener(new ButtonListenerAdapter() {
			@Override
			public void onClick(Button button, EventObject e) {

				new Documentation();
			}
		});
	}

}
