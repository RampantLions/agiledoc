package sourceagile.development.client.features;

import helpagile.client.exportation.HelpHint;
import sourceagile.client.GlobalVariables;
import sourceagile.client.InternationalizationConstants;
import sourceagile.development.client.sourceCode.SourceCodeView;
import sourceagile.shared.entities.entry.ClassFile;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HTML;

/**
 * 
 * @UserManual
 */
public class ButtonSourceCode extends HTML {

	private static InternationalizationConstants internationalizationConstants = GWT
			.create(InternationalizationConstants.class);

	public static final String imageUnpressed = "<a href='#'><img src='images/source.gif'></a>";
	public static final String imagePressed = "<a href='#'><img src='images/sourceHighlighted.gif'></a>";

	public ButtonSourceCode(final ClassFile entry) {

		this.setHTML(imageUnpressed);
		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				OptionsIcons.toggledButtons();
				OptionsIcons.buttonSourceCode.setHTML(imagePressed);

				new SourceCodeView(entry);
			}
		});

		// this.setTitle(internationalizationConstants.source());

		HelpHint.setHintHandler(this, this.getClass().getName(),
				internationalizationConstants.source(), null,
				GlobalVariables.locale);
	}
}
