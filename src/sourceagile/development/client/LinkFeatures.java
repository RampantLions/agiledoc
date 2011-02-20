package sourceagile.development.client;

import sourceagile.development.client.features.OptionsIcons;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HTML;

/**
 * 
 * @UserManual
 */
public class LinkFeatures extends HTML {

	public static final String textUnpressed = "<a href='#'><font size=1>Features</font></a>";
	public static final String textPressed = "<a href='#'><font size=1 color=orange><b>Features</b></font></a>";

	public LinkFeatures() {

		this.setHTML(textUnpressed);

		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				Development.showClassesTree(OptionsIcons.OPTION_ALLCLASSES);
			}
		});
	}

}
