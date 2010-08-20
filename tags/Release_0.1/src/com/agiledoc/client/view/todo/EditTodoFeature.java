package com.agiledoc.client.view.todo;

import com.agiledoc.client.GlobalVariables;
import com.agiledoc.client.view.util.FormField;
import com.agiledoc.shared.model.Classe;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class EditTodoFeature {

	private static TextArea description = new TextArea();
	private static TextBox priority = new TextBox();

	public EditTodoFeature(Classe classe) {

		GlobalVariables.getVP_BODY().clear();

		Label space = new Label(" ");
		space.setHeight("50");
		GlobalVariables.setVP_BODY(space);

		VerticalPanel vp = new VerticalPanel();
		vp.setBorderWidth(1);

		vp.add(featureFields(classe));

		GlobalVariables.getVP_BODY().add(vp);
	}

	/**
	 * Show the name of the class with its package name.
	 */
	public static HTML featureName(Classe classe) {

		String pack = "";

		String name = "<BR><BR><B><FONT SIZE=4>" + "&nbsp;&nbsp;"
				+ classe.getName() + "</FONT></B>";

		if (!classe.getPack().getFullName().equals(
				GlobalVariables.getProject().getFeatureFullPackage())) {

			pack = "<B>" + classe.getPack().getFullName() + "</B>";
		}

		return new HTML(pack + name);
	}

	public static VerticalPanel featureFields(Classe classe) {

		VerticalPanel vp = new VerticalPanel();
		vp.setSpacing(50);

		vp.add(featureName(classe));

		description.setSize("500", "40");
		description.setValue(classe.getClasseDoc().getDescription());
		vp.add(new FormField("Description", description));

		priority.setWidth("30");
		priority.setValue(classe.getPriority() + "");
		vp.add(new FormField("Priority Number", priority));

		vp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		vp.add(saveButton(classe));

		return vp;
	}

	private static Button saveButton(final Classe classe) {

		Button button = new Button("Save",

		new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				classe.getClasseDoc().setDescription(description.getValue());
				classe.setPriority(Integer.parseInt(priority.getValue()));

				// new CreateTodoClass(classe);
			}
		});

		return button;
	}
}
