package sourceagile.client.planning.newTask;

import sourceagile.client.project.ProjectInitialization;
import sourceagile.shared.ClassFile;

import com.google.gwt.user.client.ui.ListBox;

public class FoldersList extends ListBox {

	public FoldersList() {

		this.setWidth("250px");

		String folderName = null;

		for (ClassFile classFile : ProjectInitialization.projectEntries) {

			if (!classFile.getFeature().getFeatureFolder().equals(folderName)) {

				folderName = classFile.getFeature().getFeatureFolder();

				this.addItem(folderName, classFile.getClassPath());
			}
		}
	}

}
