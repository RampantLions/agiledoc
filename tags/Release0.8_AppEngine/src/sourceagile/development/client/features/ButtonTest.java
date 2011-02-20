package sourceagile.development.client.features;

import sourceagile.client.InternationalizationConstants;
import sourceagile.shared.entities.entry.ClassFile;
import sourceagile.testing.client.serverCalls.GetRemoteTestClass;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HTML;

/**
 * 
 * @UserManual
 */
public class ButtonTest extends HTML {

	private static InternationalizationConstants internationalizationConstants = GWT
			.create(InternationalizationConstants.class);

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

		this.setTitle(internationalizationConstants.test());

		// HelpHint.setHintHandler(this, this.getClass().getName(),
		// internationalizationConstants.test(), null,
		// GlobalVariables.locale);
	}
}
