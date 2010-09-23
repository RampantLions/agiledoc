package sourceagile.client.project;

import sourceagile.client.SystemStart;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.TextBox;

public class ProjectMenu extends HorizontalPanel {

	/**
	 * Show a panel with the root and domain string to be changed by the user.
	 */
	public ProjectMenu() {

		this.setHeight("70px");

		this.setSpacing(5);
		this.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

		final TextBox text = new TextBox();
		text.setWidth("130px");
		this.add(text);

		this.add(getSearchButton());

		this.add(getChangeProjectIcon());
	}

	/**
	 * Return the button widget that implements the Change Root functionality on
	 * the click event. After the click the system will start again with the new
	 * root and domain selected.
	 */
	public static Image getChangeProjectIcon() {

		Image img = new Image("images/changeProject.gif");

		img.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				SystemStart.mainPage.panelContent.clear();
				SystemStart.mainPage.panelContent
						.add(new ChangeProjectPanel());
			}
		});

		img.setTitle("Change current Project");

		return img;
	}

	public static Image getSearchButton() {

		Image img = new Image("images/search.gif");

		img.setTitle("Search");

		img.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

			}
		});

		return img;
	}

}
