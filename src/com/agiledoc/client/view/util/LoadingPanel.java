package com.agiledoc.client.view.util;

import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.VerticalPanel;

public class LoadingPanel {

	public static VerticalPanel show() {

		VerticalPanel vp = new VerticalPanel();

		vp.add(new Image("img/large-loading.gif"));

		return vp;
	}

}
