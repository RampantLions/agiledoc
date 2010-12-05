package sourceagile.client.systemNavigation;

import helpagile.client.exportation.HelpIcon;
import sourceagile.client.InternationalizationConstants;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.TextBox;

public class SystemOptions extends HorizontalPanel {

	private static InternationalizationConstants internationalizationConstants = GWT
			.create(InternationalizationConstants.class);

	public SystemOptions() {

		this.setHeight("70px");

		this.setSpacing(5);
		this.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

		final TextBox text = new TextBox();
		text.setWidth("130px");
		this.add(text);

		this.add(getSearchIcon());

		this.add(new HelpIcon("SourceAgile_Specification.xml"));
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

}
