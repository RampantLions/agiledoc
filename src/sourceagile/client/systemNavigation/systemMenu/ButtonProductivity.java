package sourceagile.client.systemNavigation.systemMenu;

import sourceagile.client.SystemStart;
import sourceagile.client.productivity.ProductivityPage;

import com.gwtext.client.core.EventObject;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;

public class ButtonProductivity extends Button {

	public ButtonProductivity() {

		this.setText("Productivity");

		this.addListener(new ButtonListenerAdapter() {
			@Override
			public void onClick(Button button, EventObject e) {

				SystemStart.mainPage.panelContent.clear();
				SystemStart.mainPage.panelContent.add(new ProductivityPage());
			}
		});
	}
}
