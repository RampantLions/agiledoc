package sourceagile.development.client.features;

import helpagile.client.exportation.HelpHint;
import sourceagile.client.GlobalVariables;
import sourceagile.shared.entities.entry.ClassFile;

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
public class ButtonJavadoc extends HTML {

	public static final String imageUnpressed = "<a href='#'><img src='images/javadoc.gif'></a>";
	public static final String imagePressed = "<a href='#'><img src='images/javadocHighlighted.gif'></a>";

	public PopupPanel javadocHint;

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

		javadocHint = HelpHint.getHelpHintLinked(this.getClass().getName(),
				"Javadoc", GlobalVariables.locale);

		this.addMouseOverHandler(new MouseOverHandler() {

			@Override
			public void onMouseOver(MouseOverEvent event) {

				OptionsIcons.hideHints();

				HelpHint.executeMouseOverHandler(event, javadocHint, null);

			}
		});
	}
}
