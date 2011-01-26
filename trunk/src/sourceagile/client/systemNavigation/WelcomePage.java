package sourceagile.client.systemNavigation;

import sourceagile.client.GWTStart;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class WelcomePage extends VerticalPanel {

	public WelcomePage() {

		this.setWidth("900px");

		this.setSpacing(40);

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		this.add(new Label(" "));

		this.add(new HTML("<center><font size=4>Welcome to "
				+ "<br><br><b>The Source Agile Toolkit</font></b> "
				+ "<br><br>" + GWTStart.systemVersion + "</center>"));

		this.add(new Label(" "));

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);

		this.add(new ProjectSummary());
	}

}
