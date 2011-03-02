package sourceagile.administration.client;

import sourceagile.administration.client.project.ProjectForm;
import sourceagile.shared.entities.project.Project;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * 
 * @Feature
 */
public class Administration extends VerticalPanel {

	public Administration() {

		this.setSize("500px", "500px");
		this.setBorderWidth(1);

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		this.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

		VerticalPanel vp = new VerticalPanel();
		vp.setSpacing(30);
		// vp.setSize("100%", "100%");

		vp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		HTML htmlNewProject = new HTML("<a href='#'>New Project</a>");
		htmlNewProject.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				RootPanel.get("htmlID").clear();
				RootPanel.get("htmlID").add(new ProjectForm(new Project()));
			}
		});
		vp.add(htmlNewProject);

		HTML htmlLogout = new HTML("<a href='" + GWT.getHostPageBaseURL()
				+ "'>Logout</a>");
		vp.add(htmlLogout);

		this.add(vp);
	}
}
