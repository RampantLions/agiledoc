package sourceagile.development.client.features;

import sourceagile.shared.entities.entry.ClassDocumentation;

import com.google.gwt.user.client.ui.ListBox;

public class ClassTypeList extends ListBox {

	public ClassTypeList(String classType) {

		this.setWidth("100px");

		this.addItem("");
		this.addItem(ClassDocumentation.ARCHITECTURE_TAG);
		this.addItem(ClassDocumentation.ENTITY_TAG);
		this.addItem(ClassDocumentation.FEATURE_TAG);

		if (ClassDocumentation.ARCHITECTURE_TAG.equals(classType)) {

			this.setSelectedIndex(1);

		} else if (ClassDocumentation.ENTITY_TAG.equals(classType)) {

			this.setSelectedIndex(2);

		} else if (ClassDocumentation.FEATURE_TAG.equals(classType)) {

			this.setSelectedIndex(3);
		}

	}

}
