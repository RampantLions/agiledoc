package com.agiledoc.client.view.scope;

import com.agiledoc.client.control.ListSourceMethods;
import com.agiledoc.shared.model.Classe;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * @userTask
 * 
 * @author allineo
 * @modified 04/15/2010
 */
public class TaskPage {

	public static final VerticalPanel vpMethods = new VerticalPanel();

	/**
	 * Show the class page for the task view of the system.
	 * 
	 * @author allineo
	 * @modified 04/15/2010
	 * 
	 * @link com.gwtjavadoc.server.sourceMethods.ListSourceMethods
	 */
	public static void show(Classe classe) {

		ScopeView.vpBodyScope.clear();
		ScopeView.vpBodyScope.add(showClassHeader(classe));

		new ListSourceMethods(classe);

	}

	/**
	 * Show the name of the class with its package name and description.
	 * 
	 * @author allineo
	 * @modified 04/15/2010
	 */
	public static HTML showClassHeader(final Classe classe) {

		String text = "<B>" + classe.getPack().getName() + "<BR><FONT SIZE=4>"
				+ "&nbsp;&nbsp;" + classe.getName() + "</FONT></B>";

		if (classe.getDescription() != null
				&& !classe.getDescription().equals("")) {

			text += "<FONT SIZE=\"-1\"><BR><BR>"
					+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
					+ classe.getDescription() + "</FONT>";
		}

		return new HTML(text);
	}

}
