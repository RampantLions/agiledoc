package sourceagile.planning.client;

import sourceagile.client.GlobalVariables;
import sourceagile.planning.client.TodoClasses.AddTodoClass;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

/**
 * 
 * @UserManual
 */
public class ButtonNewTask extends Button {

	public ButtonNewTask() {

		this.setText("New Task");

		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				GlobalVariables.mainPage.panelContent.clear();
				GlobalVariables.mainPage.panelContent.add(new AddTodoClass());

			}
		});
	}
}
