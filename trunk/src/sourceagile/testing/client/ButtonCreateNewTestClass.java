package sourceagile.testing.client;

import sourceagile.client.GlobalVariables;
import sourceagile.client.InternationalizationConstants;
import sourceagile.development.client.Development;
import sourceagile.shared.entities.entry.ClassFile;
import sourceagile.shared.utilities.LoadingPanel;
import sourceagile.testing.client.serverCalls.AddTestClass;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;

/**
 * 
 * @UserManual
 */
public class ButtonCreateNewTestClass extends Button {

	private static InternationalizationConstants internationalizationConstants = GWT
			.create(InternationalizationConstants.class);

	public ButtonCreateNewTestClass(final ClassFile entry) {

		this.setText(internationalizationConstants.createUnitTest());

		this.addListener(new ButtonListenerAdapter() {

			@Override
			public void onClick(Button button, EventObject e) {

				if (GlobalVariables.isReadyOnly) {

					Window.alert("Sorry. This version doesn't allow you to make changes inside the source code.");

				} else {

					Development.featureVisualizationPanel.clear();
					Development.featureVisualizationPanel
							.add(new LoadingPanel());

					new AddTestClass(entry);
				}
			}
		});
	}

}
