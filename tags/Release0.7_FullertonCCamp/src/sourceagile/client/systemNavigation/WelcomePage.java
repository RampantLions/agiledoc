package sourceagile.client.systemNavigation;

import sourceagile.client.GlobalVariables;

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
				+ "<br><br><b><font size=6 color=orange>LIVE SOURCE</font>"
				+ "<font size=5><br>an Agile Toolkit</font></b> "
				+ "<br><br><font size=4>" + GlobalVariables.systemVersion
				+ "</center>"));

		this.add(new Label(" "));

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);

		this.add(new ProjectSummary());
	}

}
