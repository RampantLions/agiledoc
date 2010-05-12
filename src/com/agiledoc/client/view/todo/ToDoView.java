package com.agiledoc.client.view.todo;

import com.agiledoc.client.GlobalVariables;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ToDoView {

	public ToDoView() {

		GlobalVariables.getVP_BODY().clear();

		VerticalPanel vp = new VerticalPanel();
		vp.setBorderWidth(1);
		vp.setSize("97%", "100%");

		VerticalPanel vp1 = new VerticalPanel();
		vp1.setSize("100%", "100%");
		vp1.setSpacing(30);
		vp1.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		vp1.add(newTaskButton());

		vp1.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		vp1.add(new ToDoList());

		vp.add(vp1);

		GlobalVariables.setVP_BODY(vp);
	}

	public static Button newTaskButton() {

		Button button = new Button("New Feature", new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				new NewTaskForm();
			}
		});

		return button;
	}
}
