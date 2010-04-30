package com.agiledoc.client.view.todo;

import com.agiledoc.client.GlobalVariables;
import com.agiledoc.client.view.util.FormField;
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
public class NewTaskForm {

	public static void init() {

		GlobalVariables.getVP_BODY().clear();

		Label space = new Label(" ");
		space.setHeight("50");
		GlobalVariables.setVP_BODY(space);

		VerticalPanel vp = new VerticalPanel();
		vp.setBorderWidth(1);

		vp.add(show());

		GlobalVariables.getVP_BODY().add(vp);
	}

	/**
	 * Show a panel with the root and domain string to be changed by the user.
	 * 
	 * @link com.gwtjavadoc.client.view.components.ButtonChangeSystemRoot
	 */
	public static VerticalPanel show() {

		VerticalPanel vp = new VerticalPanel();
		vp.setSpacing(50);

		HTML title = new HTML("<B>Enter the new Task information bellow: </B>");
		vp.add(title);

		TextBox path = new TextBox();
		path.setWidth("300");
		vp.add(new FormField("Task Path", path));

		TextBox name = new TextBox();
		name.setWidth("300");
		vp.add(new FormField("Task Name", name));

		TextArea desc = new TextArea();
		desc.setSize("500", "40");
		vp.add(new FormField("Description", desc));

		vp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		Button button = new Button("Create New Task",

		new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				// new ListSourceClasses(GlobalVariables.getPACK());
			}
		});
		vp.add(button);

		return vp;
	}

}
