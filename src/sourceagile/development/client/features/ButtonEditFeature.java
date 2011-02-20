package sourceagile.development.client.features;

import sourceagile.client.InternationalizationConstants;
import sourceagile.development.client.features.edit.FeatureEdit;
import sourceagile.shared.entities.entry.ClassFile;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HTML;

/**
 * 
 * @UserManual
 */
public class ButtonEditFeature extends HTML {

	private static InternationalizationConstants internationalizationConstants = GWT
			.create(InternationalizationConstants.class);

	public static final String imageUnpressed = "<a href='#'><img src='images/edit.gif'></a>";
	public static final String imagePressed = "<a href='#'><img src='images/editHighlighted.gif'></a>";

	public ButtonEditFeature(final ClassFile entry) {

		this.setHTML(imageUnpressed);
		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				OptionsIcons.toggledButtons();
				OptionsIcons.buttonEditFeature.setHTML(imagePressed);

				new FeatureEdit(entry);
			}
		});

		this.setTitle(internationalizationConstants.edit());

		// HelpHint.setHintHandler(this,
		// "sourceagile.development.client.features.ButtonEditFeature",
		// internationalizationConstants.edit(), null, GlobalVariables.locale);
	}
}
