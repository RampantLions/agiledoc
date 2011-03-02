package sourceagile.development.client.features.edit;

import sourceagile.development.client.features.FeatureDescription;
import sourceagile.development.client.features.FeatureVizualizationPanel;
import sourceagile.shared.entities.entry.ClassDocumentation;
import sourceagile.shared.entities.entry.ClassFile;
import sourceagile.shared.entities.entry.Method;

import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;



/** 
 * Edit the documentation of a class in a web form. Good for Stakeholders send precise messages to programmers.
 * 
 * @MainFeature 
 */
public class FeatureEdition extends VerticalPanel {

	public static TextArea classDescription = new TextArea();
	public static CheckBox isTodo = new CheckBox(" To Do");
	public static ClassTypeList classTypeList;

	public FeatureEdition(ClassFile entry) {

		FeatureVizualizationPanel.featureContent.clear();

		HorizontalPanel hp = new HorizontalPanel();

		hp.add(FeatureDescription.featureName(entry, false));

		hp.add(featureTypes(entry.getClassDoc()));

		this.add(hp);

		this.add(featureDescription(entry.getClassDoc()));

		if (entry.getClassDoc().getMethods() != null) {
			add(featureMethods(entry.getClassDoc().getMethods()));
		}

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		this.add(new ButtonSave(entry));

		FeatureVizualizationPanel.featureContent.add(this);
	}

	private HorizontalPanel featureTypes(ClassDocumentation classDoc) {

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
}
