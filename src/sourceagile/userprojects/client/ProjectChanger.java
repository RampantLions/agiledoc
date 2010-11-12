package sourceagile.userprojects.client;

import sourceagile.authentication.client.ProjectList;
import sourceagile.shared.data.ProjectsData;
import sourceagile.shared.entities.project.Project;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;

public class ProjectChanger extends ProjectList {

	public ProjectChanger() {

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
					ProjectForm.testRoot.setValue(projs[getSelectedIndex() - 1]
							.getTestRoot());
					ProjectForm.domain.setValue(projs[getSelectedIndex() - 1]
							.getDomain());
					ProjectForm.specificationPath
							.setValue(projs[getSelectedIndex() - 1]
									.getSpecificationPath());
					ProjectForm.wiki.setValue(projs[getSelectedIndex() - 1]
							.getWiki());

					ProjectForm.projectComponents = projs[getSelectedIndex() - 1]
							.getProjectComponents();
				}
			}
		});
	}
}
