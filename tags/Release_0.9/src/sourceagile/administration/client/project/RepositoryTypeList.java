package sourceagile.administration.client.project;

import sourceagile.shared.entities.project.Project;

import com.google.gwt.user.client.ui.ListBox;

/**
 * 
 * @UserManual
 */
public class RepositoryTypeList extends ListBox {

	public RepositoryTypeList(String repositoryTypeSelected) {

		this.setWidth("200px");

		this.addItem(Project.REPOSITORY_TYPE_SUBVERSION);
		this.addItem(Project.REPOSITORY_TYPE_GIT);
		this.addItem(Project.REPOSITORY_TYPE_XML);

		if (Project.REPOSITORY_TYPE_SUBVERSION.equals(repositoryTypeSelected)) {

			this.setSelectedIndex(0);

		} else if (Project.REPOSITORY_TYPE_GIT.equals(repositoryTypeSelected)) {

			this.setSelectedIndex(1);

		} else if (Project.REPOSITORY_TYPE_XML.equals(repositoryTypeSelected)) {

			this.setSelectedIndex(2);
		}
	}
}
