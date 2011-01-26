package sourceagile.authentication.client;

import java.util.List;

import sourceagile.client.GWTStart;
import sourceagile.shared.entities.project.Project;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * First page of the system where the user can insert credentials.
 * 
 * @UserManual
 */
public class LoginPage extends HorizontalPanel {

	public LoginPage(List<Project> projects) {

		this.setSize("100%", "100%");

		this.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

		VerticalPanel vp = new VerticalPanel();

		vp.setWidth("800px");

		vp.setSpacing(60);

		vp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		vp.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

		vp.add(new Label(" "));

		vp.add(new HTML("<center><font size=5>Welcome to </font>"
				+ "<br><br><b><font size=6>The Source Agile Toolkit</b> "
				+ "<br><br><font size=4>" + GWTStart.systemVersion
				+ "</font></center>"));

		vp.add(new LoginForm(projects));

		this.add(vp);

		this.add(new NewsPanel());
	}
}
