package sourceagile.development.client.features;

import sourceagile.shared.entities.entry.ClassDocumentation;
import sourceagile.shared.utilities.FeatureNameGenerator;

import com.google.gwt.user.client.ui.ListBox;

public class ClassTypeList extends ListBox {

	public ClassTypeList(String classType) {

		this.setWidth("100px");

		this.addItem("");
		this.addItem(FeatureNameGenerator
				.spacedName(ClassDocumentation.ARCHITECTURE_TAG),
				ClassDocumentation.ARCHITECTURE_TAG);
		this.addItem(
				FeatureNameGenerator.spacedName(ClassDocumentation.ENTITY_TAG),
				ClassDocumentation.ENTITY_TAG);
		this.addItem(
				FeatureNameGenerator.spacedName(ClassDocumentation.FEATURE_TAG),
				ClassDocumentation.FEATURE_TAG);
		this.addItem(FeatureNameGenerator
				.spacedName(ClassDocumentation.USER_FEATURE_TAG),
				ClassDocumentation.USER_FEATURE_TAG);

		if (ClassDocumentation.ARCHITECTURE_TAG.equals(classType)) {

			this.setSelectedIndex(1);

		} else if (ClassDocumentation.ENTITY_TAG.equals(classType)) {

			this.setSelectedIndex(2);

		} else if (ClassDocumentation.FEATURE_TAG.equals(classType)) {

			this.setSelectedIndex(3);

		} else if (ClassDocumentation.USER_FEATURE_TAG.equals(classType)) {

			this.setSelectedIndex(4);
		}
	}
}
