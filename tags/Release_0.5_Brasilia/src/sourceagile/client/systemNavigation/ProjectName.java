package sourceagile.client.systemNavigation;

import sourceagile.client.InternationalizationConstants;
import sourceagile.userprojects.client.ProjectInitialization;
import sourceagile.userprojects.client.serverCalls.ListProjects;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ProjectName extends VerticalPanel {

	private static InternationalizationConstants internationalizationConstants = GWT
			.create(InternationalizationConstants.class);

	public ProjectName() {

		setSize("150px", "70px");
		setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

		HTML html = new HTML("<b>"
				+ ProjectInitialization.currentProject.getName() + "</b><br> "
				+ internationalizationConstants.project());

		html.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				new ListProjects();
			}
		});

		add(html);

	}

}
