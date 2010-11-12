package sourceagile.client.systemNavigation.projectMenu;

import sourceagile.client.SystemStart;
import sourceagile.metrics.client.ProductivityPage;

import com.gwtext.client.core.EventObject;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;

public class ButtonProductivity extends Button {

	public ButtonProductivity() {

		this.setText("Metrics");

		this.addListener(new ButtonListenerAdapter() {
			@Override
			public void onClick(Button button, EventObject e) {

				SystemStart.mainPage.panelContent.clear();
				SystemStart.mainPage.panelContent.add(new ProductivityPage());
			}
		});
	}
}
