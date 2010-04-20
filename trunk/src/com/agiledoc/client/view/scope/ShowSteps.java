package com.agiledoc.client.view.scope;

import com.agiledoc.client.control.GetSourceClassTasks;
import com.agiledoc.shared.model.Classe;
import com.agiledoc.shared.model.Method;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * @task
 * 
 * @author allineo
 * @modified 04/14/2010
 */
public class ShowSteps {

	/**
	 * For each method, show its name and description.
	 * 
	 * @author allineo
	 * @modified 04/14/2010
	 */
	public static VerticalPanel showMethods(final Method[] meths) {

		VerticalPanel vp = new VerticalPanel();
		vp.setSpacing(10);

		for (Method meth : meths) {

			vp.add(new HTML("&nbsp;&nbsp;<B>" + meth.getSpacedName() + "</B>"));

			if (meth.getDescription() != null
					&& !meth.getDescription().equals("")) {

				vp.add(new HTML("&nbsp;&nbsp;&nbsp;&nbsp;"
						+ meth.getDescription()));
			}

			vp.add(showLinks(meth));

			vp.add(new Label(" "));
		}

		return vp;
	}

	/**
	 * List method links.
	 * 
	 * @author allineo
	 * @modified 04/14/2010
	 */
	public static HorizontalPanel showLinks(final Method meth) {

		HorizontalPanel links = new HorizontalPanel();

		if (meth.getLinks().length > 0) {

			links
					.add(new HTML(
							"&nbsp;&nbsp;&nbsp;&nbsp;See:&nbsp;&nbsp;&nbsp;"));

			for (final Classe link : meth.getLinks()) {

				Anchor classeAnchor = new Anchor(link.getName());
				classeAnchor.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent sender) {

						new GetSourceClassTasks(link.getFullName());
					}
				});

				links.add(classeAnchor);

				links.add(new HTML("&nbsp;&nbsp;"));
			}
		}
		return links;
	}

}
