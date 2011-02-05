package sourceagile.planning.client.TodoClasses;

import sourceagile.shared.entities.entry.ClassFile;
import sourceagile.userprojects.client.ProjectInitialization;

import com.google.gwt.user.client.ui.ListBox;

public class FoldersList extends ListBox {

	public FoldersList() {

		this.setWidth("250px");

		String folderName = "";

		this.addItem(folderName, folderName);

		for (ClassFile classFile : ProjectInitialization.projectEntries) {

			String featureFolder = classFile.getFeature().getFeatureFolder();

			if (!featureFolder.equals(folderName)) {

				folderName = classFile.getFeature().getFeatureFolder();

				this.addItem(folderName, classFile.getFilePath());
			}
		}
	}

}