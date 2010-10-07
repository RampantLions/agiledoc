package sourceagile.client.systemNavigation;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class WelcomePage extends VerticalPanel {

	public WelcomePage() {

		setSpacing(20);

		add(new Label(" "));

		add(new HTML("<center><font size=4>Welcome to "
				+ "<br><br><b>The Source Code Agile Experiment</font></b> "
				+ "<br><br>Prototype Version</center>"));
	}

}
