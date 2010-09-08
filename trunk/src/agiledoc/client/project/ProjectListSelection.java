package agiledoc.client.project;

import agiledoc.shared.Project;
import agiledoc.shared.data.ProjectsData;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.ui.ListBox;

public class ProjectListSelection extends ListBox {

	public ProjectListSelection() {

		this.setWidth("200");

		for (Project proj : ProjectsData.load()) {

			this.addItem(proj.getName());
		}

		this.addChangeHandler(new ChangeHandler() {

			@Override
			public void onChange(ChangeEvent event) {

				Project[] projs = ProjectsData.load();

				ProjectForm.name.setValue(projs[getSelectedIndex()].getName());
				ProjectForm.url.setValue(projs[getSelectedIndex()]
						.getRepositoryURL());
				ProjectForm.root.setValue(projs[getSelectedIndex()].getRoot());
				ProjectForm.domain.setValue(projs[getSelectedIndex()]
						.getDomain());
			}
		});
	}

}
