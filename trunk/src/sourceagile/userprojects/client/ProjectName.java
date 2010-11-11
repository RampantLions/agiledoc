package sourceagile.userprojects.client;

import sourceagile.client.SystemStart;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ProjectName extends VerticalPanel {

	public ProjectName() {

		setSize("150px", "70px");
		setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

		HTML html = new HTML("<b>"
				+ ProjectInitialization.currentProject.getName()
				+ "</b><br> Project");

		html.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				SystemStart.mainPage.panelContent.clear();
				SystemStart.mainPage.panelContent.add(new ProjectSelection());
			}
		});

		add(html);

	}

}
