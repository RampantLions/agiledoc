package sourceagile.userprojects.client;

import java.util.List;

import sourceagile.client.ProjectInitialization;
import sourceagile.shared.entities.project.Project;
import sourceagile.shared.entities.project.ProjectBacklog;
import sourceagile.shared.entities.project.ProjectComponents;
import sourceagile.shared.utilities.FormField;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ProjectForm extends VerticalPanel {

	public static long projectID = 0;
	public static final TextBox name = new TextBox();
	public static final TextBox url = new TextBox();
	public static final TextBox root = new TextBox();
	public static final TextBox testRoot = new TextBox();
	public static final TextBox domain = new TextBox();
	public static final TextBox specificationPath = new TextBox();
	public static final TextBox wiki = new TextBox();
	public static String description = null;

	public static List<ProjectComponents> projectComponents = null;
	public static List<ProjectBacklog> projectBacklog = null;

	public ProjectForm() {

		this.setSpacing(30);

		HTML title = new HTML(
				"<B>OR <BR><BR>Enter the information required for a new Project: </B>");
		this.add(title);

		projectID = ProjectInitialization.currentProject.getProjectID();

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

		description = ProjectInitialization.currentProject.getDescription();

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		HorizontalPanel hp = new HorizontalPanel();

		hp.setSpacing(50);

		hp.add(buttonSaveProject());

		hp.add(buttonChangeProject());

		this.add(hp);
	}

	private Project loadProjectInfo() {

		Project proj = new Project();

		proj.setProjectID(projectID);
		proj.setRepositoryType(Project.REPOSITORY_TYPE_SUBVERSION);
		proj.setName(name.getValue());
		proj.setRepositoryURL(url.getValue());
		proj.setRoot(root.getValue());
		proj.setTestRoot(testRoot.getValue());
		proj.setDomain(domain.getValue());
		proj.setSpecificationPath(specificationPath.getValue());
		proj.setWiki(wiki.getValue());
		proj.setDescription(description);

		proj.setProjectComponents(ProjectForm.projectComponents);
		proj.setProjectBacklog(ProjectForm.projectBacklog);

		return proj;
	}

	private Button buttonSaveProject() {

		Button button = new Button("Save", new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				// new SaveProject(loadProjectInfo());
			}
		});

		return button;
	}

	private Button buttonChangeProject() {

		Button button = new Button("Open this Project", new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				new ProjectInitialization(loadProjectInfo());
			}
		});

		return button;
	}

	public static void setProjectForm(Project project) {

		projectID = project.getProjectID();
		name.setValue(project.getName());
		url.setValue(project.getRepositoryURL());
		root.setValue(project.getRoot());
		testRoot.setValue(project.getTestRoot());
		domain.setValue(project.getDomain());
		specificationPath.setValue(project.getSpecificationPath());
		wiki.setValue(project.getWiki());
		description = project.getDescription();

		projectComponents = project.getProjectComponents();
		projectBacklog = project.getProjectBacklog();
	}
}
