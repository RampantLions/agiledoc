package sourceagile.development.client.features;

import helpagile.client.exportation.HelpHint;
import sourceagile.client.GlobalVariables;
import sourceagile.client.InternationalizationConstants;
import sourceagile.shared.entities.entry.ClassFile;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.PopupPanel;

/**
 * 
 * @UserManual
 */
public class ButtonFeatureDescription extends HTML {

	private static InternationalizationConstants internationalizationConstants = GWT
			.create(InternationalizationConstants.class);

	public static final String imageUnpressed = "<a href='#'><img src='/images/list.gif'></a>";
	public static final String imagePressed = "<a href='#'><img src='/images/listHighlighted.gif'></a>";

	public PopupPanel descriptionHint;

	public ButtonFeatureDescription(final ClassFile entry) {

		this.setHTML(imageUnpressed);
		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				FeatureVizualizationPanel.featureContent.clear();

				OptionsIcons.toggledButtons();
				OptionsIcons.buttonDescription.setHTML(imagePressed);

				new FeatureDescription(entry);
			}
		});

		// this.setTitle(internationalizationConstants.description());

		descriptionHint = HelpHint.getHelpHintLinked(this.getClass().getName(),
				internationalizationConstants.description(),
				GlobalVariables.locale);

		this.addMouseOverHandler(new MouseOverHandler() {

			@Override
			public void onMouseOver(MouseOverEvent event) {

				OptionsIcons.hideHints();

				HelpHint.executeMouseOverHandler(event, descriptionHint, null);

			}
		});
	}
}
