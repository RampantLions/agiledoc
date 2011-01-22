package sourceagile.development.client.features;

import sourceagile.development.client.serverCalls.EditClass;
import sourceagile.shared.entities.entry.ClassDocumentation;
import sourceagile.shared.entities.entry.ClassFile;
import sourceagile.shared.entities.entry.Method;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Edit the documentation of the class in a web form.
 * 
 * @feature
 */
public class FeatureEdit extends VerticalPanel {

	private TextArea classDescription = new TextArea();
	private CheckBox isTodo = new CheckBox(" To Do");
	private ClassTypeList classTypeList;

	public FeatureEdit(ClassFile entry) {

		FeatureVizualizationPanel.featureContent.clear();

		HorizontalPanel hp = new HorizontalPanel();

		hp.add(FeatureDescription.featureName(entry.getFeature()));

		hp.add(featureOptions(entry.getClassDoc()));

		this.add(hp);

		this.add(featureDescription(entry.getClassDoc()));

		if (entry.getClassDoc().getMethods() != null) {
			add(featureMethods(entry.getClassDoc().getMethods()));
		}

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		this.add(saveButton(entry));

		FeatureVizualizationPanel.featureContent.add(this);
	}

	private HorizontalPanel featureOptions(ClassDocumentation classDoc) {

		HorizontalPanel hp = new HorizontalPanel();

		hp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		hp.setSpacing(20);

		classTypeList = new ClassTypeList(classDoc.getTagType());

		hp.add(new Label("Type:"));
		hp.add(classTypeList);

		isTodo.setValue(classDoc.isTodo());

		hp.add(isTodo);

		return hp;
	}

	private HorizontalPanel featureDescription(ClassDocumentation classDoc) {

		HorizontalPanel hp = new HorizontalPanel();
		hp.setSpacing(20);

		classDescription.setSize("600px", "60px");
		classDescription.setText(classDoc.getDescription());

		hp.add(classDescription);
		return hp;
	}

	private Grid featureMethods(final Method[] meths) {

		Grid table = new Grid(meths.length * 3, 2);

		table.getColumnFormatter().setWidth(0, "40px");

		for (int i = 0; i < meths.length; i++) {

			Method meth = meths[i];

			table.setWidget((i * 3), 1, new HTML("<B>" + meth.getSpacedName()
					+ "</B>"));

			TextArea textArea = new TextArea();
			textArea.setSize("550px", "50px");
			textArea.setText(meth.getDescription());

			table.setWidget((i * 3 + 1), 1, textArea);

			table.setWidget((i * 3 + 2), 0, new Label(" "));
		}

		return table;
	}

	private Button saveButton(final ClassFile classFile) {

		Button button = new Button("Save",

		new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				classFile.getClassDoc().setTodo(isTodo.getValue());

				String classType = classTypeList.getValue(classTypeList
						.getSelectedIndex());

				if (classType.length() == 0) {

					classType = null;
				}

				classFile.getClassDoc().setTagType(classType);

				new EditClass(classFile, classDescription.getValue());
			}
		});

		return button;
	}
}
