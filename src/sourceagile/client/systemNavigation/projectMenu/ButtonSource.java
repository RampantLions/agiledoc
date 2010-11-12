package sourceagile.client.systemNavigation.projectMenu;

import sourceagile.documentation.client.classViewOptions.OptionsIcons;
import sourceagile.documentation.client.specification.Specification;

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
