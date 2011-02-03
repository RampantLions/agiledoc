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

	public static final String textUnpressed = "<font size=1>Features</font>";
	public static final String textPressed = "<font size=1 color=orange><b>Features</b></font>";

	public LinkFeatures() {

		this.setHTML(textUnpressed);
		this.setWidth("60px");

		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				Development.showClassesTree(OptionsIcons.OPTION_ALLCLASSES);
			}
		});
	}

}
