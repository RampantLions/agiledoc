package sourceagile.client.project;

import sourceagile.client.GlobalVariables;
import sourceagile.client.ProjectInitialization;
import sourceagile.shared.entities.project.ProjectComponents;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;

/**
 * 
 * @Feature
 */
public class ProjectComponentsList extends FlexTable {

	public ProjectComponentsList() {

		setBorderWidth(1);
		setWidth("900px");

		setCellPadding(5);

		gridColumns();

		gridRows();
	}

	private void gridColumns() {

		this.setHTML(0, 0, "<B>Name</B>");
		this.getColumnFormatter().setWidth(0, "300px");

		this.setHTML(0, 1, "<B>Path</B>");
		this.getColumnFormatter().setWidth(1, "350px");

		this.setHTML(0, 2, " ");
		this.getColumnFormatter().setWidth(6, "50px");
	}

	private void gridRows() {

		for (int i = 0; i < ProjectInitialization.currentProject
				.getProjectComponents().size(); i++) {

			ProjectComponents component = ProjectInitialization.currentProject
					.getProjectComponents().get(i);

			this.setText(i, 0, component.getComponentName());
			this.setText(i, 1, component.getComponentPath());

			HorizontalPanel hp = new HorizontalPanel();
			hp.setSpacing(10);
			hp.add(iconEdit(i));
			hp.add(iconDelete(i));

			this.setWidget(i, 2, hp);

		}
	}

	private static HTML iconEdit(final Integer componentIndex) {

		HTML img = new HTML("<a href='#'><img src='images/edit.gif'></a>");
		img.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				GlobalVariables.mainPage.panelContent.clear();
				GlobalVariables.mainPage.panelContent
						.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
				GlobalVariables.mainPage.panelContent
						.add(new ProjectComponentForm(componentIndex));
				GlobalVariables.mainPage.panelContent
						.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
			}
		});

		img.setTitle("Edit Project Component");

		return img;
	}

	private static HTML iconDelete(Integer componentIndex) {

		HTML img = new HTML("<a href='#'><img src='images/delete.gif'></a>");
		img.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

			}
		});

		img.setTitle("Delete Project Component");

		return img;
	}
}
