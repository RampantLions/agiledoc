package sourceagile.development.client.features;

import helpagile.client.exportation.HelpHint;
import sourceagile.client.GlobalVariables;
import sourceagile.client.InternationalizationConstants;
import sourceagile.client.ProjectInitialization;
import sourceagile.shared.entities.entry.ClassFile;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.PopupPanel;

/**
 * 
 * @UserManual
 */
public class ButtonExecute extends HTML {

	private static InternationalizationConstants internationalizationConstants = GWT
			.create(InternationalizationConstants.class);

	public static final String imageUnpressed = "<img src='/images/play.gif'>";
	public static final String imagePressed = "<a href='#'><img src='/images/playHighlighted.gif'></a>";

	public PopupPanel executeHint;

	public ButtonExecute(final ClassFile entry) {

		String fileURL = ProjectInitialization.currentProject
				.getRepositoryURL() + "/" + entry.toString();

		this.setHTML("<a href='" + fileURL + "' target=_blank>"
				+ imageUnpressed + "</a>");
		/*
		 * this.addClickHandler(new ClickHandler() {
		 * 
		 * @Override public void onClick(ClickEvent event) {
		 * 
		 * OptionsIcons.toggledButtons(); //
		 * OptionsIcons.buttonExecute.setHTML(imagePressed);
		 * 
		 * // new GetRemoteTestClass(entry); } });
		 */

		executeHint = HelpHint
				.getHelpHintLinked(this.getClass().getName(),
						internationalizationConstants.execute(),
						GlobalVariables.locale);

		this.addMouseOverHandler(new MouseOverHandler() {

			@Override
			public void onMouseOver(MouseOverEvent event) {

				OptionsIcons.hideHints();

				HelpHint.executeMouseOverHandler(event, executeHint, null);

			}
		});
	}
}
