package sourceagile.development.client;

import sourceagile.development.client.features.OptionsIcons;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;

/**
 * 
 * @UserManual
 */
public class LinkSource extends Anchor {

	public static final String textUnpressed = "<font size=1>Source</font>";
	public static final String textPressed = "<font size=1 color=orange><b>Source</b></font>";

	public LinkSource() {

		this.setHTML(textUnpressed);

		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				Development.showClassesTree(OptionsIcons.OPTION_SOURCE);
			}
		});
	}

}
