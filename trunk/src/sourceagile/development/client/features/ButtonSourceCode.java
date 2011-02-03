package sourceagile.development.client.features;

import sourceagile.development.client.sourceCode.SourceCodeView;
import sourceagile.shared.entities.entry.ClassFile;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HTML;

/**
 * 
 * @UserManual
 */
public class ButtonSourceCode extends HTML {

	public ButtonSourceCode(final ClassFile entry) {

		this.setHTML("<a href='#'><img src='images/source.gif'></a>");
		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				new SourceCodeView(entry);
			}
		});

		this.setTitle("Source Code");
	}
}
