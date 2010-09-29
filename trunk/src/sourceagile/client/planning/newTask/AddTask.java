package sourceagile.client.planning.newTask;

import sourceagile.client.project.ProjectInitialization;
import sourceagile.client.serverConnection.CreateTodoClass;
import sourceagile.client.systemNavigation.FormField;
import sourceagile.shared.ClassDocumentation;
import sourceagile.shared.ClassFile;
import sourceagile.shared.Feature;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
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
 description of the task in a web based form page. 
TODO: need to change this class with Add To Do Class.
 * 
 * @todo
 * @feature 
 */ 
public class AddTask extends VerticalPanel {

	private ListBox folders = new FoldersList();
	private TextBox newFolderName = new TextBox();
	private TextBox taskName = new TextBox();
	private TextArea taskDescription = new TextArea();

	public AddTask() {

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
		taskName.setValue(null);
		vp.add(new FormField("Name", taskName));

		taskDescription.setSize("700px", "80px");
		taskDescription.setValue(null);
		vp.add(new FormField("Description", taskDescription));

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
		newFolderName.setValue(null);
		hp.add(newFolderName);

		return hp;
	}

	private Button saveTaskButton() {

		Button button = new Button("Save New Task",

		new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				new CreateTodoClass(getClassFile());

			}
		});

		return button;
	}

	private ClassFile getClassFile() {

		ClassFile classFile = new ClassFile();

		classFile.setClassName(taskName.getValue());

		classFile.setClassDomain(ProjectInitialization.currentProject
				.getDomain());
		classFile.setClassPath(folders.getValue(folders.getSelectedIndex()));

		if (newFolderName.getValue() != null
				&& newFolderName.getValue().length() > 0) {

			Feature feature = new Feature();
			feature.setFeatureFolder(newFolderName.getValue().trim());

			classFile.setFeature(feature);
		}

		ClassDocumentation classeDoc = new ClassDocumentation();
		classeDoc.setDescription(taskDescription.getValue());
		classFile.setClassDoc(classeDoc);

		return classFile;
	}
}
