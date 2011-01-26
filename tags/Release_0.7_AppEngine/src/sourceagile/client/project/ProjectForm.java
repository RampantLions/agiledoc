package sourceagile.client.project;

import sourceagile.shared.entities.project.Project;
import sourceagile.shared.utilities.FormField;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ProjectForm extends VerticalPanel {

	public static final TextBox name = new TextBox();
	public static final ListBox repositoryType = new ListBox();
	public static final TextBox url = new TextBox();
	public static final TextBox root = new TextBox();
	public static final TextBox testRoot = new TextBox();
	public static final TextBox domain = new TextBox();

	public ProjectForm(Project project) {

		this.setBorderWidth(1);

		VerticalPanel vp = new VerticalPanel();

		vp.setSpacing(30);

		name.setWidth("500px");
		name.setValue(project.getName());
		vp.add(new FormField("Project Name", name));

		url.setWidth("500px");
		url.setValue(project.getRepositoryURL());
		vp.add(new FormField("Repository URL", url));

		root.setWidth("500px");
		root.setValue(project.getRoot());
		vp.add(new FormField("Root", root));

		testRoot.setWidth("300px");
		testRoot.setValue(project.getTestRoot());
		vp.add(new FormField("Test Root", testRoot));

		domain.setWidth("300px");
		domain.setValue(project.getDomain());
		vp.add(new FormField("Domain", domain));

		vp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		HorizontalPanel hp = new HorizontalPanel();

		hp.setSpacing(50);

		hp.add(buttonSaveProject(project));

		vp.add(hp);

		this.add(vp);
	}

	private Button buttonSaveProject(final Project project) {

		Button button = new Button("Save", new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				project.setRepositoryType(Project.REPOSITORY_TYPE_SUBVERSION);
				project.setName(name.getValue());
				project.setRepositoryURL(url.getValue());
				project.setRoot(root.getValue());
				project.setTestRoot(testRoot.getValue());
				project.setDomain(domain.getValue());

				new SaveProject(project);
			}
		});

		return button;
	}

}
