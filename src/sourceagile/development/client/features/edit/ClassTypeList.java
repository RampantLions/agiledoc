package sourceagile.development.client.features.edit;

import sourceagile.client.GlobalVariables;
import sourceagile.shared.entities.entry.ClassDocumentation;
import sourceagile.shared.utilities.FeatureNameGenerator;

import com.google.gwt.user.client.ui.ListBox;

/**
 * 
 * @UserManual
 */
public class ClassTypeList extends ListBox {

	public ClassTypeList(String classType) {

		this.setWidth("100px");

		this.addItem("");

		this.addItem(FeatureNameGenerator.spacedName(
				ClassDocumentation.ARCHITECTURE_TAG, GlobalVariables.locale),
				ClassDocumentation.ARCHITECTURE_TAG);

		this.addItem(FeatureNameGenerator.spacedName(
				ClassDocumentation.ENTITY_TAG, GlobalVariables.locale),
				ClassDocumentation.ENTITY_TAG);

		this.addItem(FeatureNameGenerator.spacedName(
				ClassDocumentation.MAIN_FEATURE_TAG, GlobalVariables.locale),
				ClassDocumentation.MAIN_FEATURE_TAG);

		this.addItem(FeatureNameGenerator.spacedName(
				ClassDocumentation.FEATURE_TAG, GlobalVariables.locale),
				ClassDocumentation.FEATURE_TAG);

		this.addItem(FeatureNameGenerator.spacedName(
				ClassDocumentation.USER_INTERFACE_TAG, GlobalVariables.locale),
				ClassDocumentation.USER_INTERFACE_TAG);

		if (ClassDocumentation.ARCHITECTURE_TAG.equals(classType)) {

			this.setSelectedIndex(1);

		} else if (ClassDocumentation.ENTITY_TAG.equals(classType)) {

			this.setSelectedIndex(2);

		} else if (ClassDocumentation.MAIN_FEATURE_TAG.equals(classType)) {

			this.setSelectedIndex(3);

		} else if (ClassDocumentation.FEATURE_TAG.equals(classType)) {

			this.setSelectedIndex(4);

		} else if (ClassDocumentation.USER_INTERFACE_TAG.equals(classType)) {

			this.setSelectedIndex(5);
		}
	}
}
