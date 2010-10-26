package sourceagile.client.systemNavigation;

import helpagile.client.visualizationWidgets.HelpIcon;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.TextBox;

public class SystemOptions extends HorizontalPanel {

	public SystemOptions() {

		this.setHeight("70px");

		this.setSpacing(5);
		this.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

		final TextBox text = new TextBox();
		text.setWidth("130px");
		this.add(text);

		this.add(getSearchIcon());

		this.add(new HelpIcon());
	}

	public static Image getSearchIcon() {

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
