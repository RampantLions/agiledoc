package sourceagile.authentication.client;

import java.util.List;

import sourceagile.client.GlobalVariables;
import sourceagile.shared.entities.project.Project;

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
public class LoginPage extends VerticalPanel {

	public LoginPage(List<Project> projects) {

		this.setSize("100%", "100%");

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		this.add(new LanguageOptions());

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);

		this.add(new LoginForm(projects));

		this.add(new Label(" "));

		HorizontalPanel hpMain = new HorizontalPanel();

		hpMain.setSize("100%", "100%");

		hpMain.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

		hpMain.setSpacing(20);

		hpMain.add(new HowToUse(GlobalVariables.locale));

		hpMain.add(new BlogArchiveList(GlobalVariables.locale));

		this.add(hpMain);
	}

}
