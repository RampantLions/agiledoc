package sourceagile.testing.client;

import sourceagile.client.InternationalizationConstants;
import sourceagile.development.client.sourceCode.SourceCodeView;
import sourceagile.shared.entities.entry.ClassFile;

import com.google.gwt.core.client.GWT;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;

/**
 * 
 * @UserManual
 */
public class ButtonViewTestSourceCode extends Button {

	private static InternationalizationConstants internationalizationConstants = GWT
			.create(InternationalizationConstants.class);

	public ButtonViewTestSourceCode(final ClassFile testClassFile) {

		this.setText(internationalizationConstants.viewSourceCode());

		this.addListener(new ButtonListenerAdapter() {

			@Override
			public void onClick(Button button, EventObject e) {

				new SourceCodeView(testClassFile);
			}
		});

	}

}
