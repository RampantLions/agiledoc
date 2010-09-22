package sourceagile.client.planning;

import sourceagile.client.project.ProjectInitialization;
import sourceagile.client.serverConnection.CreateTodoClass;
import sourceagile.client.systemNavigation.FormField;
import sourceagile.shared.ClassDocumentation;
import sourceagile.shared.ClassFile;

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
 * The user can insert a new task in the system typing the name, description and
 * the priority of the task in a web based form page.
 * 
 */
public class NewTodoClass extends VerticalPanel {

	private static ListBox folders = new ListBox();
	private static TextBox name = new TextBox();
	private static TextArea description = new TextArea();

	public NewTodoClass() {

		Label space = new Label(" ");
		space.setHeight("50px");
		this.add(space);

		VerticalPanel vp = new VerticalPanel();
		vp.setBorderWidth(1);

		getFeaturesPacks();

		vp.add(featureFields());

		this.add(vp);
	}

	private void getFeaturesPacks() {

		folders.clear();

		String folderName = null;

		for (ClassFile classFile : ProjectInitialization.projectEntries) {

			if (!classFile.getFeature().getFeatureFolder().equals(folderName)) {

				folderName = classFile.getFeature().getFeatureFolder();

				folders.addItem(folderName, classFile.getClassPath());
			}
		}
	}

	public static HorizontalPanel comboPackages() {

		HorizontalPanel hp = new HorizontalPanel();
		hp.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

		folders.setWidth("300px");
		hp.add(new FormField("Package", folders));

		hp.add(new Label(" "));

		Button button = new Button("New Package",

		new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

			}
		});
		hp.add(button);

		return hp;
	}

	public static VerticalPanel featureFields() {

		VerticalPanel vp = new VerticalPanel();
		vp.setSpacing(50);

		HTML title = new HTML("<B>Enter the new feature bellow: </B>");
		vp.add(title);

		vp.add(comboPackages());

		name.setWidth("500px");
		vp.add(new FormField("Name", name));

		description.setSize("700px", "80px");
		vp.add(new FormField("Description", description));

		vp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		vp.add(saveButton());

		return vp;
	}

	private static Button saveButton() {

		Button button = new Button("Create New Feature",

		new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				ClassDocumentation classeDoc = new ClassDocumentation();
				classeDoc.setDescription(description.getValue());

				ClassFile classFile = new ClassFile();
				classFile.setClassDomain(ProjectInitialization.currentProject
						.getDomain());
				classFile.setClassPath(folders.getValue(folders
						.getSelectedIndex()));
				classFile.setClassName(name.getValue());
				classFile.setClassDoc(classeDoc);

				new CreateTodoClass(classFile);

			}
		});

		return button;
	}
}
