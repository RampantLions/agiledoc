package sourceagile.client.userFeatures.systemNavigation.systemMenu;

import sourceagile.client.userFeatures.specification.Specification;

import com.gwtext.client.core.EventObject;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;

public class ButtonSpecification extends Button {

	public ButtonSpecification() {

		this.setText("Specification");

		this.addListener(new ButtonListenerAdapter() {
			@Override
			public void onClick(Button button, EventObject e) {

				new Specification();
			}
		});
	}

}
