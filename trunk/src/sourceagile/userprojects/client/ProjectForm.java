package sourceagile.userprojects.client;

import sourceagile.client.systemNavigation.FormField;
import sourceagile.shared.entities.project.Project;

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
	public static final TextBox testRoot = new TextBox();
	public static final TextBox domain = new TextBox();
	public static final TextBox specificationPath = new TextBox();
	public static final TextBox wiki = new TextBox();

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

		testRoot.setWidth("300px");
		testRoot.setValue(ProjectInitialization.currentProject.getTestRoot());
		this.add(new FormField("Test Root", testRoot));

		domain.setWidth("300px");
		domain.setValue(ProjectInitialization.currentProject.getDomain());
		this.add(new FormField("Domain", domain));

		specificationPath.setWidth("300px");
		specificationPath.setValue(ProjectInitialization.currentProject
				.getSpecificationPath());
		this.add(new FormField("Specification Path", specificationPath));

		wiki.setWidth("300px");
		wiki.setValue(ProjectInitialization.currentProject.getWiki());
		this.add(new FormField("Wiki", wiki));

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

				proj.setRepositoryType(Project.REPOSITORY_TYPE_SUBVERSION);
				proj.setName(name.getValue());
				proj.setRepositoryURL(url.getValue());
				proj.setRoot(root.getValue());
				proj.setTestRoot(testRoot.getValue());
				proj.setDomain(domain.getValue());
				proj.setSpecificationPath(specificationPath.getValue());
				proj.setWiki(wiki.getValue());

				new ProjectInitialization(proj);
			}
		});

		return button;
	}

}
