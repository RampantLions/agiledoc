package sourceagile.development.client.features;

import helpagile.client.exportation.HelpHint;
import sourceagile.client.GlobalVariables;
import sourceagile.shared.entities.entry.ClassFile;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HTML;

/**
 * 
 * @UserManual
 */
public class ButtonJavadoc extends HTML {

	public static final String imageUnpressed = "<a href='#'><img src='images/javadoc.gif'></a>";
	public static final String imagePressed = "<a href='#'><img src='images/javadocHighlighted.gif'></a>";

	public ButtonJavadoc(final ClassFile entry) {

		this.setHTML(imageUnpressed);
		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				OptionsIcons.toggledButtons();
				OptionsIcons.buttonJavadoc.setHTML(imagePressed);

				new JavadocView(entry);
			}
		});

		this.setTitle("Javadoc");

		HelpHint.setHintHandler(this, this.getClass().getName(), "Javadoc",
				null, GlobalVariables.locale);
	}
}
