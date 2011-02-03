package sourceagile.client.systemNavigation;

import helpagile.client.exportation.HelpWindow;

import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;

public class SystemTopOptions extends HorizontalPanel {

	public SystemTopOptions() {

		this.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		this.setWidth("220px");

		this.add(new SearchBox());

		Label labelSpace = new Label(" ");
		labelSpace.setWidth("15px");
		this.add(labelSpace);

		this.add(new HomeIcon());

		this.add(HelpWindow.helpIcon("SourceAgile"));
	}

}
