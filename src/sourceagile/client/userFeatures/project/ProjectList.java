package sourceagile.client.userFeatures.project;

import sourceagile.shared.Project;
import sourceagile.shared.data.ProjectsData;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.ui.ListBox;

public class ProjectList extends ListBox {

	public ProjectList() {

		this.setWidth("200");

		this.addItem("");

		for (Project proj : ProjectsData.load()) {

			this.addItem(proj.getName());
		}

		this.addChangeHandler(new ChangeHandler() {

			@Override
			public void onChange(ChangeEvent event) {

				if (getSelectedIndex() > 0) {

					Project[] projs = ProjectsData.load();

					ProjectForm.name.setValue(projs[getSelectedIndex() - 1]
							.getName());
					ProjectForm.url.setValue(projs[getSelectedIndex() - 1]
							.getRepositoryURL());
					ProjectForm.root.setValue(projs[getSelectedIndex() - 1]
							.getRoot());
					ProjectForm.domain.setValue(projs[getSelectedIndex() - 1]
							.getDomain());
				}
			}
		});
	}

}
