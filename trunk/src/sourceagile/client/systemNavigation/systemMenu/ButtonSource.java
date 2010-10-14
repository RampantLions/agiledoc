package sourceagile.client.userFeatures.systemNavigation.systemMenu;

import sourceagile.client.userFeatures.specification.Specification;
import sourceagile.client.userFeatures.specification.classViewOptions.OptionsIcons;

import com.gwtext.client.core.EventObject;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;

public class ButtonSource extends Button {

	public ButtonSource() {

		this.setText("Source");

		this.addListener(new ButtonListenerAdapter() {
			@Override
			public void onClick(Button button, EventObject e) {

				new Specification(null, OptionsIcons.OPTION_SOURCE);
			}
		});
	}

}
