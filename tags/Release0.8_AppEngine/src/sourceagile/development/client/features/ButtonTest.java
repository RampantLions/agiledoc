package sourceagile.development.client.features;

import helpagile.client.exportation.HelpHint;
import sourceagile.shared.entities.entry.ClassFile;
import sourceagile.testing.client.serverCalls.GetRemoteTestClass;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HTML;

/**
 * 
 * @UserManual
 */
public class ButtonTest extends HTML {

	public static final String imageUnpressed = "<a href='#'><img src='images/test.gif'></a>";
	public static final String imagePressed = "<a href='#'><img src='images/testHighlighted.gif'></a>";

	public ButtonTest(final ClassFile entry) {

		this.setHTML(imageUnpressed);
		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				OptionsIcons.toggledButtons();
				OptionsIcons.buttonTest.setHTML(imagePressed);

				new GetRemoteTestClass(entry);
			}
		});

		HelpHint.setHintHandler(this, this.getClass().getName(), "Test", null);
	}
}
