package com.agiledoc.client.view.todo;

import com.agiledoc.client.GlobalVariables;
import com.agiledoc.client.control.CreateTodoClass;
import com.agiledoc.client.view.util.FormField;
import com.agiledoc.shared.model.Classe;
import com.agiledoc.shared.model.Classedoc;
import com.agiledoc.shared.model.Pack;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * The user can insert a new task in the system typing the name, description and
 * the priority of the task in a web based form page.
 * 
 */
public class NewTodoFeature {

	private static TextBox path = new TextBox();
	private static TextBox name = new TextBox();
	private static TextArea description = new TextArea();
	private static TextBox priority = new TextBox();

	public NewTodoFeature() {

		GlobalVariables.getVP_BODY().clear();

		Label space = new Label(" ");
		space.setHeight("50");
		GlobalVariables.setVP_BODY(space);

		VerticalPanel vp = new VerticalPanel();
		vp.setBorderWidth(1);

		vp.add(featureFields());

		GlobalVariables.getVP_BODY().add(vp);
	}

	public static VerticalPanel featureFields() {

		VerticalPanel vp = new VerticalPanel();
		vp.setSpacing(50);

		HTML title = new HTML("<B>Enter the new feature bellow: </B>");
		vp.add(title);

		path.setWidth("300");
		vp.add(new FormField("Path", path));

		name.setWidth("300");
		vp.add(new FormField("Name", name));

		description.setSize("500", "40");
		vp.add(new FormField("Description", description));

		priority.setWidth("30");
		vp.add(new FormField("Priority Number", priority));

		vp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		vp.add(saveButton());

		return vp;
	}

	private static Button saveButton() {

		Button button = new Button("Create New Feature",

		new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				Pack pack = new Pack();
				pack.setName(path.getValue());

				Classedoc classeDoc = new Classedoc();
				classeDoc.setClassName(name.getValue());
				classeDoc.setDescription(description.getValue());

				Classe classe = new Classe();
				classe.setPack(pack);
				classe.setClasseDoc(classeDoc);

				classe.setPriority(Integer.parseInt(priority.getValue()));

				new CreateTodoClass(classe);
			}
		});

		return button;
	}
}
