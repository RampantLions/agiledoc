package com.agiledoc.client.view.root;

import com.agiledoc.client.GlobalVariables;
import com.agiledoc.client.util.FormField;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * @task
 */
public class ChangeRootForm {

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

		HTML title = new HTML(
				"<B>Enter the new Root and the new Domain bellow: </B>");
		vp.add(title);

		TextBox root = new TextBox();
		root.setWidth("500");
		root.setValue(GlobalVariables.getROOT());
		vp.add(new FormField("Root", root));

		TextBox pack = new TextBox();
		pack.setWidth("300");
		pack.setValue(GlobalVariables.getPACK());
		vp.add(new FormField("Domain", pack));

		vp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		vp.add(ButtonChangeRoot.getButton(root, pack));

		return vp;
	}

}
