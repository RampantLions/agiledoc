package sourceagile.client.userFeatures.documentation.features;

import sourceagile.client.serverCalls.EditClass;
import sourceagile.client.userFeatures.documentation.classViewOptions.ClassVizualizationPanel;
import sourceagile.shared.ClassDocumentation;
import sourceagile.shared.ClassFile;
import sourceagile.shared.Method;

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
	private CheckBox isFeature = new CheckBox(" Feature");

	public FeatureEdit(ClassFile entry) {

		ClassVizualizationPanel.featureContent.clear();

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

		ClassVizualizationPanel.featureContent.add(this);
	}

	private HorizontalPanel featureOptions(ClassDocumentation classDoc) {

		HorizontalPanel hp = new HorizontalPanel();

		hp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		hp.setSpacing(20);

		isTodo.setValue(classDoc.isTodo());
		isFeature.setValue(classDoc.isFeature());

		hp.add(isTodo);
		hp.add(isFeature);

		return hp;
	}

	private HorizontalPanel featureDescription(ClassDocumentation classDoc) {

		HorizontalPanel hp = new HorizontalPanel();
		hp.setSpacing(20);

		classDescription.setSize("600px", "40px");
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
			textArea.setSize("550px", "40px");
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
				classFile.getClassDoc().setFeature(isFeature.getValue());

				new EditClass(classFile, classDescription.getValue());
			}
		});

		return button;
	}
}
