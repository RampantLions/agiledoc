package com.agiledoc.client.view.help;

import com.agiledoc.client.control.GetSourceClassHelp;
import com.agiledoc.shared.model.Classe;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;

/**
 * @userTask
 * 
 * @author allineo
 * @modified 04/15/2010
 */
public class TopicPage {

	/**
	 * Show the name of the topic with its description.
	 * 
	 * @author allineo
	 * @modified 04/15/2010
	 */
	public static void showHelpTopic(final Classe classe) {

		String text = "<FONT SIZE=4><B>" + classe.getName() + "</B></FONT>";

		if (classe.getDescription() != null
				&& !classe.getDescription().equals("")) {

			text += "<BR><BR>"
					+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
					+ classe.getDescription();
		}

		HelpView.vpBodyHelp.clear();
		HelpView.vpBodyHelp.add(new HTML(text));
		HelpView.vpBodyHelp.add(showLinks(classe));
	}

	/**
	 * List help links.
	 * 
	 * @author allineo
	 * @modified 04/15/2010
	 */
	public static HorizontalPanel showLinks(final Classe classe) {

		HorizontalPanel links = new HorizontalPanel();

		if (classe.getLinks().length > 0) {

			links
					.add(new HTML(
							"&nbsp;&nbsp;&nbsp;&nbsp;See:&nbsp;&nbsp;&nbsp;"));

			for (final Classe link : classe.getLinks()) {

				Anchor classeAnchor = new Anchor(link.getName());
				classeAnchor.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent sender) {

						new GetSourceClassHelp(link.getFullName());
					}
				});

				links.add(classeAnchor);

				links.add(new HTML("&nbsp;&nbsp;"));
			}
		}
		return links;
	}

}
