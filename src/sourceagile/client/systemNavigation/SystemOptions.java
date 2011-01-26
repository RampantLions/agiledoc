package sourceagile.client.systemNavigation;

import helpagile.client.exportation.HelpWindow;
import sourceagile.client.GlobalVariables;
import sourceagile.client.InternationalizationConstants;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

public class SystemOptions extends HorizontalPanel {

	private static InternationalizationConstants internationalizationConstants = GWT
			.create(InternationalizationConstants.class);

	public SystemOptions() {

		this.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		this.setWidth("220px");

		final TextBox text = new TextBox();
		text.setWidth("130px");
		this.add(text);

		this.add(getSearchIcon());

		Label labelSpace = new Label(" ");
		labelSpace.setWidth("15px");
		this.add(labelSpace);

		this.add(homeIcon());

		this.add(HelpWindow.helpIcon("SourceAgile"));
	}

	public static Image getSearchIcon() {

		Image img = new Image("images/search.gif");

		img.setTitle(internationalizationConstants.search());

		img.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

			}
		});

		return img;
	}

	public static Image homeIcon() {

		Image img = new Image("images/home.gif");

		img.setTitle("Project Home");

		img.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				GlobalVariables.mainPage = new MainPage();

				RootPanel.get("htmlID").clear();
				RootPanel.get("htmlID").add(GlobalVariables.mainPage);
			}
		});

		return img;
	}

}
