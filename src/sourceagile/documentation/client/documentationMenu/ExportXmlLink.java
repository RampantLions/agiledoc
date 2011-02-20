package sourceagile.documentation.client.documentationMenu;

import sourceagile.client.InternationalizationConstants;
import sourceagile.documentation.client.Documentation;
import sourceagile.documentation.client.serverCalls.ListAllComments;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HTML;

/**
 * 
 * @UserManual
 */
public class ExportXmlLink extends HTML {

	private static InternationalizationConstants internationalizationConstants = GWT
			.create(InternationalizationConstants.class);

	public static final String textUnpressed = "<a href='#'>"
			+ internationalizationConstants.export() + " XML</a>";
	public static final String textPressed = "<a href='#'><font color=orange><b>"
			+ internationalizationConstants.export()
			+ " XML"
			+ "</b></font></a>";

	public ExportXmlLink() {

		this.setHTML(textUnpressed);
		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				Documentation.untoggleLinks();
				Documentation.exportXmlLink.setHTML(textPressed);

				new ListAllComments();
			}
		});

	}
}
