package sourceagile.development.client.sourceCode;

import sourceagile.client.GlobalVariables;
import sourceagile.development.client.serverCalls.EditClass;
import sourceagile.shared.entities.entry.ClassDocumentation;
import sourceagile.shared.entities.entry.ClassFile;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;

/**
 * 
 * @UserManual
 */
public class ButtonInProgress extends Button {

	public ButtonInProgress(final ClassFile classFile) {

		this.setText(ClassDocumentation.INPROGRESS_STATUS);

		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				if (GlobalVariables.isReadyOnly) {

					Window.alert("Sorry. This version doesn't allow you to make changes inside the source code.");

				} else {

					classFile.getClassDoc().setClassStatus(
							ClassDocumentation.INPROGRESS_STATUS);

					new EditClass(classFile, classFile.getClassDoc()
							.getDescription());
				}
			}
		});
	}
}
