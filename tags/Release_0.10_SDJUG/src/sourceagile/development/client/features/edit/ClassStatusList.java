package sourceagile.development.client.features.edit;

import sourceagile.client.GlobalVariables;
import sourceagile.shared.entities.entry.ClassDocumentation;
import sourceagile.shared.utilities.FeatureNameGenerator;

import com.google.gwt.user.client.ui.ListBox;

/**
 * 
 * @UserManual
 */
public class ClassStatusList extends ListBox {

	public ClassStatusList(String classStatus) {

		this.setWidth("100px");

		this.addItem("");

		this.addItem(FeatureNameGenerator.spacedName(
				ClassDocumentation.TODO_STATUS, GlobalVariables.locale),
				ClassDocumentation.TODO_STATUS);

		this.addItem(FeatureNameGenerator.spacedName(
				ClassDocumentation.INPROGRESS_STATUS, GlobalVariables.locale),
				ClassDocumentation.INPROGRESS_STATUS);

		this.addItem(FeatureNameGenerator.spacedName(
				ClassDocumentation.BLOCKED_STATUS, GlobalVariables.locale),
				ClassDocumentation.BLOCKED_STATUS);

		if (ClassDocumentation.TODO_STATUS.equals(classStatus)) {

			this.setSelectedIndex(1);

		} else if (ClassDocumentation.INPROGRESS_STATUS.equals(classStatus)) {

			this.setSelectedIndex(2);

		} else if (ClassDocumentation.BLOCKED_STATUS.equals(classStatus)) {

			this.setSelectedIndex(3);

		}
	}
}
