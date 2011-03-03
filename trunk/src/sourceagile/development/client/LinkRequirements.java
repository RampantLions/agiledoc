package sourceagile.development.client;

import sourceagile.client.InternationalizationConstants;
import sourceagile.development.client.features.OptionsIcons;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HTML;

/**
 * 
 * @UserManual
 */
public class LinkRequirements extends HTML {

	private static InternationalizationConstants internationalizationConstants = GWT
			.create(InternationalizationConstants.class);

	public static final String textUnpressed = "<a href='#'><font size=1>"
			+ internationalizationConstants.requirements() + "</font></a>";
	public static final String textPressed = "<a href='#'><font size=1 color=orange><b>"
			+ internationalizationConstants.requirements() + "</b></font></a>";

	public LinkRequirements() {

		this.setHTML(textUnpressed);

		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				Development.showClassesTree(OptionsIcons.OPTION_REQUIREMENTS);
			}
		});
	}

}
