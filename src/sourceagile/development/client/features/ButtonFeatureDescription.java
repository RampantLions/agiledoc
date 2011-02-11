package sourceagile.development.client.features;

import sourceagile.shared.entities.entry.ClassFile;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HTML;

/**
 * 
 * @UserManual
 */
public class ButtonFeatureDescription extends HTML {

	public static final String imageUnpressed = "<a href='#'><img src='images/list.gif'></a>";
	public static final String imagePressed = "<a href='#'><img src='images/listHighlighted.gif'></a>";

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

		this.setTitle("Feature Description");
	}
}
