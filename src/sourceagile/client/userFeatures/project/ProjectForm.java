package sourceagile.client.userFeatures.project;

import sourceagile.client.userFeatures.systemNavigation.FormField;
import sourceagile.shared.Project;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ProjectForm extends VerticalPanel {

	public static final TextBox name = new TextBox();
	public static final TextBox url = new TextBox();
	public static final TextBox root = new TextBox();
	public static final TextBox domain = new TextBox();

	public ProjectForm() {

		this.setSpacing(30);

		HTML title = new HTML(
				"<B>OR <BR><BR>Enter the information required for a new Project: </B>");
		this.add(title);

		name.setWidth("500px");
		name.setValue(ProjectInitialization.currentProject.getName());
		this.add(new FormField("Project Name", name));

		url.setWidth("500px");
		url.setValue(ProjectInitialization.currentProject.getRepositoryURL());
		this.add(new FormField("Repository URL", url));

		root.setWidth("500px");
		root.setValue(ProjectInitialization.currentProject.getRoot());
		this.add(new FormField("Root", root));

		domain.setWidth("300px");
		domain.setValue(ProjectInitialization.currentProject.getDomain());
		this.add(new FormField("Domain", domain));

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		Label space = new Label(" ");
		space.setHeight("20px");
		this.add(space);

		this.add(buttonChangeProject());
	}

	private Button buttonChangeProject() {

		Button button = new Button("Change Project", new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				Project proj = new Project();

				proj.setName(name.getValue());
				proj.setRepositoryURL(url.getValue());
				proj.setRoot(root.getValue());
				proj.setDomain(domain.getValue());

				new ProjectInitialization(proj);
			}
		});

		return button;
	}

}
