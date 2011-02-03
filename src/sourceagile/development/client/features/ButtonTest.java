package sourceagile.development.client.features;

import sourceagile.shared.entities.entry.ClassFile;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HTML;

/**
 * 
 * @UserManual
 */
public class ButtonTest extends HTML {

	public ButtonTest(final ClassFile entry) {

		this.setHTML("<a href='#'><img src='images/test.gif'></a>");
		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				// new GetRemoteTestClass(entry, OPTION_TEST);
			}
		});

		this.setTitle("Test");
	}
}
