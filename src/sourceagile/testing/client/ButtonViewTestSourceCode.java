package sourceagile.testing.client;

import sourceagile.development.client.sourceCode.SourceCodeView;
import sourceagile.shared.entities.entry.ClassFile;

import com.gwtext.client.core.EventObject;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;

/**
 * 
 * @UserManual
 */
public class ButtonViewTestSourceCode extends Button {

	public ButtonViewTestSourceCode(final ClassFile testClassFile) {

		this.setText("View Test Source Code");

		this.addListener(new ButtonListenerAdapter() {

			@Override
			public void onClick(Button button, EventObject e) {

				new SourceCodeView(testClassFile);
			}
		});

	}

}
