package sourceagile.client.userFeatures.planning.TodoClasses;

import sourceagile.client.serverCalls.CreateTodoClass;
import sourceagile.client.serverCalls.test.AddTestClass;
import sourceagile.client.userFeatures.project.ProjectInitialization;
import sourceagile.client.userFeatures.systemNavigation.FormField;
import sourceagile.shared.ClassDocumentation;
import sourceagile.shared.ClassFile;
import sourceagile.shared.Feature;
import sourceagile.shared.utilities.FileNameGenerator;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * The user can insert a new task in the source code typing the name and
 * description of the task in a web based form page.
 * 
 * @feature
 */
public class AddTodoClass extends VerticalPanel {

	private ListBox folders = new FoldersList();
	private TextBox newFolderName = new TextBox();
	private TextBox taskName = new TextBox();
	private TextArea taskDescription = new TextArea();
	private CheckBox createTest = new CheckBox(" Create Test");

	public AddTodoClass() {

		Label space = new Label(" ");
		space.setHeight("50px");
		this.add(space);

		VerticalPanel vp = new VerticalPanel();
		vp.setBorderWidth(1);

		vp.add(taskForm());

		this.add(vp);
	}

	public VerticalPanel taskForm() {

		VerticalPanel vp = new VerticalPanel();
		vp.setSpacing(50);

		HTML title = new HTML("<B>Enter the new task bellow: </B>");
		vp.add(title);

		vp.add(foldersPanel());

		taskName.setWidth("500px");
		taskName.setValue("");
		vp.add(new FormField("Name", taskName));

		taskDescription.setSize("700px", "80px");
		taskDescription.setValue("");
		vp.add(new FormField("Description", taskDescription));

		createTest.setValue(true);
		vp.add(createTest);

		vp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		vp.add(saveTaskButton());

		return vp;
	}

	public HorizontalPanel foldersPanel() {

		HorizontalPanel hp = new HorizontalPanel();
		hp.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

		hp.add(new FormField("Folder", folders));

		hp.add(newFolderPanel());

		return hp;
	}

	public HorizontalPanel newFolderPanel() {

		HorizontalPanel hp = new HorizontalPanel();

		hp.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		hp.setSpacing(5);

		HTML title = new HTML(" &nbsp;&nbsp;&nbsp; or enter a new subfolder: ");
		hp.add(title);

		newFolderName.setWidth("150px");
		newFolderName.setValue("");
		hp.add(newFolderName);

		return hp;
	}

	private Button saveTaskButton() {

		Button button = new Button("Save New Task",

		new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				ClassFile classFile = getClassFile();

				new CreateTodoClass(classFile);

				if (createTest.getValue()) {

					new AddTestClass(classFile);
				}

			}
		});

		return button;
	}

	private ClassFile getClassFile() {

		ClassFile classFile = new ClassFile();

		String className = FileNameGenerator.compactName(taskName.getValue());

		String filePath = folders.getValue(folders.getSelectedIndex());

		classFile.setFileName(className);

		classFile.setClassDomain(ProjectInitialization.currentProject
				.getDomain());
		classFile.setFilePath(filePath);

		if (newFolderName.getValue() != null
				&& newFolderName.getValue().length() > 0) {

			Feature feature = new Feature();
			feature.setFeatureFolder(FileNameGenerator.compactName(
					newFolderName.getValue(), true));

			classFile.setFeature(feature);
		}

		ClassDocumentation classDoc = new ClassDocumentation();

		classDoc.setClassName(className);

		classDoc.setClassPackage(filePath.replaceAll("/", "."));

		classDoc.setDescription(taskDescription.getValue());

		classFile.setClassDoc(classDoc);

		return classFile;
	}
}