package sourceagile.authentication.client;

import sourceagile.authentication.client.serverCalls.AddNewProject;
import sourceagile.shared.entities.project.Project;
import sourceagile.shared.utilities.FormField;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * 
 * @UserManual
 */
public class ProjectForm extends VerticalPanel {

	public static final TextBox name = new TextBox();
	public static LocaleList locale;
	public static RepositoryTypeList repositoryType;
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
		vp.add(FormField.getFormField("Project Name", name));

		locale = new LocaleList(project.getProjectLocale());
		vp.add(FormField.getFormField("Project Language", locale));

		repositoryType = new RepositoryTypeList(project.getRepositoryType());
		vp.add(FormField.getFormField("Repository Type", repositoryType));

		url.setWidth("500px");
		url.setValue(project.getRepositoryURL());
		vp.add(FormField.getFormField("Repository URL", url));

		root.setWidth("500px");
		root.setValue(project.getRoot());
		vp.add(FormField.getFormField("Root", root));

		testRoot.setWidth("300px");
		testRoot.setValue(project.getTestRoot());
		vp.add(FormField.getFormField("Test Root", testRoot));

		domain.setWidth("300px");
		domain.setValue(project.getDomain());
		vp.add(FormField.getFormField("Domain", domain));

		vp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		HorizontalPanel hp = new HorizontalPanel();

		hp.setWidth("300px");

		hp.add(buttonSaveProject(project));

		hp.add(buttonCancel());

		vp.add(hp);

		this.add(vp);
	}

	private Button buttonSaveProject(final Project project) {

		Button button = new Button("Save", new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				project.setRepositoryType(repositoryType
						.getValue(repositoryType.getSelectedIndex()));
				project.setProjectLocale(locale.getValue(locale
						.getSelectedIndex()));
				project.setName(name.getValue());
				project.setRepositoryURL(url.getValue());
				project.setRoot(root.getValue());
				project.setTestRoot(testRoot.getValue());
				project.setDomain(domain.getValue());

				new AddNewProject(project);

				ButtonNewProject.dialogbox.hide(true);
			}
		});

		return button;
	}

	private Button buttonCancel() {

		Button button = new Button("Close", new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				ButtonNewProject.dialogbox.hide(true);
			}
		});

		return button;
	}

}
