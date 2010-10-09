package sourceagile.client.systemNavigation.systemMenu;

import com.gwtext.client.core.EventObject;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;

public class ButtonWiki extends Button {

	public ButtonWiki() {

		this.setText("Wiki");

		this.addListener(new ButtonListenerAdapter() {
			@Override
			public void onClick(Button button, EventObject e) {

			}
		});
	}

}
