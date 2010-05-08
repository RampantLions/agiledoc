package com.agiledoc.client.view.project;

import com.agiledoc.client.GlobalVariables;
import com.agiledoc.client.control.ListSourceClasses;
import com.agiledoc.client.view.util.FormField;
import com.agiledoc.shared.data.ProjectsData;
import com.agiledoc.shared.model.Project;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ChangeProjectPage {

	private static ListBox list = new ListBox();

	public static void init() {

		GlobalVariables.getVP_BODY().clear();

		Label space = new Label(" ");
		space.setHeight("50");
		GlobalVariables.setVP_BODY(space);

		VerticalPanel vp = new VerticalPanel();
		vp.setBorderWidth(1);

		vp.add(comboProjects());

		formNewProject(vp);
	}

	public static VerticalPanel comboProjects() {

		VerticalPanel vp = new VerticalPanel();
		vp.setSpacing(20);

		HTML title = new HTML("<B>Select a Project on the list bellow: </B>");
		vp.add(title);

		list = new ListBox();
		list.setWidth("200");

		for (Project proj : ProjectsData.load()) {

			list.addItem(proj.getName());
		}

		vp.add(list);

		return vp;
	}

	public static void formNewProject(VerticalPanel vpMain) {

		VerticalPanel vp = new VerticalPanel();
		vp.setSpacing(30);

		HTML title = new HTML(
				"<B>OR <BR><BR>Enter the information required for a new Project: </B>");
		vp.add(title);

		final TextBox name = new TextBox();
		name.setWidth("500");
		name.setValue(GlobalVariables.getProject().getName());
		vp.add(new FormField("Project Name", name));

		final TextBox root = new TextBox();
		root.setWidth("500");
		root.setValue(GlobalVariables.getProject().getRoot());
		vp.add(new FormField("Root", root));

		final TextBox domain = new TextBox();
		domain.setWidth("300");
		domain.setValue(GlobalVariables.getProject().getDomain());
		vp.add(new FormField("Domain", domain));

		final TextBox viewPack = new TextBox();
		viewPack.setWidth("300");
		viewPack.setValue(GlobalVariables.getProject().getViewPackage());
		vp.add(new FormField("View Package", viewPack));

		vp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		list.addChangeHandler(new ChangeHandler() {

			@Override
			public void onChange(ChangeEvent event) {

				Project[] projs = ProjectsData.load();

				name.setValue(projs[list.getSelectedIndex()].getName());
				root.setValue(projs[list.getSelectedIndex()].getRoot());
				domain.setValue(projs[list.getSelectedIndex()].getDomain());
				viewPack.setValue(projs[list.getSelectedIndex()]
						.getViewPackage());
			}
		});

		vpMain.add(vp);

		GlobalVariables.getVP_BODY().add(vpMain);

		Label space = new Label(" ");
		space.setHeight("20");
		GlobalVariables.getVP_BODY().add(space);

		Button button = new Button("Change Project", new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				Project proj = new Project();

				proj.setName(name.getValue());
				proj.setRoot(root.getValue());
				proj.setDomain(domain.getValue());
				proj.setViewPackage(viewPack.getValue());

				GlobalVariables.setProject(proj);

				new ListSourceClasses();
			}
		});
		GlobalVariables.getVP_BODY().add(button);
	}

}
