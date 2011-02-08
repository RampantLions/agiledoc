package sourceagile.planning.client.TodoClasses;

import sourceagile.development.client.Development;
import sourceagile.development.client.features.OptionsIcons;
import sourceagile.shared.entities.entry.ClassFile;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HTML;

/**
 * 
 * @UserManual
 */
public class IconViewTodoClass extends HTML {

	public IconViewTodoClass(final ClassFile entry) {

		this.setHTML("<a href='#'><img src='images/list.gif'></a>");
		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				new Development(entry, OptionsIcons.OPTION_DESCRIPTION);
			}
		});

		this.setTitle("Show Planning Feature");
	}
}
