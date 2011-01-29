package sourceagile.documentation.client.documentationMenu;

import sourceagile.client.InternationalizationConstants;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;

/**
 * 
 * @TODO
 * @UserManual
 */
public class ExportPdfLink extends Anchor {

	private static InternationalizationConstants internationalizationConstants = GWT
			.create(InternationalizationConstants.class);

	public ExportPdfLink() {

		this.setText(internationalizationConstants.export() + " PDF");
		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

			}
		});

	}
}
