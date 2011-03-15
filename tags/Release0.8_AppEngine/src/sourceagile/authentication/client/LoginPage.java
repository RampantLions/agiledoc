package sourceagile.authentication.client;

import helpagile.client.exportation.HelpWindow;

import java.util.List;

import sourceagile.client.GlobalVariables;
import sourceagile.client.InternationalizationConstants;
import sourceagile.shared.entities.project.Project;

import com.google.gwt.core.client.GWT;
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
public class LoginPage extends VerticalPanel {

	private InternationalizationConstants internationalizationConstants = GWT
			.create(InternationalizationConstants.class);

	public LoginPage(List<Project> projects) {

		this.setSize("100%", "100%");

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		this.add(new LanguageOptions());

		HorizontalPanel hpMain = new HorizontalPanel();

		hpMain.setSize("100%", "100%");

		hpMain.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

		hpMain.setSpacing(20);

		VerticalPanel vp = new VerticalPanel();

		vp.setSize("650px", "100%");

		vp.setSpacing(20);

		vp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		vp.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

		vp.add(new Label(" "));

		vp.add(welcomePanel());

		vp.add(new Label(" "));

		HorizontalPanel hp = new HorizontalPanel();

		hp.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

		hp.add(new LoginForm(projects));

		Label labelSpace = new Label(" ");
		labelSpace.setWidth("20px");
		hp.add(labelSpace);

		hp.add(new ProjectSelectionPanel(projects));

		vp.add(hp);

		vp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		HorizontalPanel hpButtonLogin = new HorizontalPanel();

		hpButtonLogin
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);

		hpButtonLogin.setWidth("400px");

		hpButtonLogin.add(new ButtonLogin());

		hpButtonLogin.add(HelpWindow.helpLink("LiveSource", "false", null,
				internationalizationConstants.readMore(),
				GlobalVariables.locale));

		vp.add(hpButtonLogin);

		hpMain.add(vp);

		hpMain.add(new BlogArchiveList(GlobalVariables.locale));

		this.add(hpMain);
	}

	private HTML welcomePanel() {

		HTML html = new HTML("<center><font size=5>"
				+ internationalizationConstants.welcomeTo() + " </font>"
				+ "<br><br><b><font size=6 color=orange>LIVE SOURCE</font>"
				+ "<font size=5><br>Agile Toolkit</font></b> "
				+ "<br><br><font size=4>" + GlobalVariables.systemVersion
				+ "</font></center>");

		return html;
	}
}