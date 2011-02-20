package sourceagile.documentation.client.documentationMenu;

import sourceagile.client.InternationalizationConstants;
import sourceagile.documentation.client.Documentation;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HTML;

/**
 * 
 * @TODO
 * @UserManual
 */
public class ExportPdfLink extends HTML {

	private static InternationalizationConstants internationalizationConstants = GWT
			.create(InternationalizationConstants.class);

	public static final String textUnpressed = "<a href='#'>"
			+ internationalizationConstants.export() + " PDF</a>";
	public static final String textPressed = "<a href='#'><font color=orange><b>"
			+ internationalizationConstants.export()
			+ " PDF"
			+ "</b></font></a>";

	public ExportPdfLink() {

		this.setHTML(textUnpressed);
		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				Documentation.untoggleLinks();
				Documentation.exportPdfLink.setHTML(textPressed);

			}
		});

	}
}
