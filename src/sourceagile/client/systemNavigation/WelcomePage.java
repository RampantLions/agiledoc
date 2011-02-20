package sourceagile.client.systemNavigation;

import sourceagile.client.GlobalVariables;
import sourceagile.client.InternationalizationConstants;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class WelcomePage extends HorizontalPanel {

	private static InternationalizationConstants internationalizationConstants = GWT
			.create(InternationalizationConstants.class);

	public WelcomePage() {

		this.setVerticalAlignment(HasVerticalAlignment.ALIGN_BOTTOM);

		this.add(new AboutProject());

		this.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

		VerticalPanel vp = new VerticalPanel();

		vp.setWidth("900px");

		vp.setSpacing(40);

		vp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		vp.add(new Label(" "));

		vp.add(new HTML("<center><font size=4> "
				+ internationalizationConstants.welcomeTo()
				+ "<br><br><b><font size=6 color=orange>LIVE SOURCE</font>"
				+ "<font size=5><br>Agile Toolkit</font></b> "
				+ "<br><br><font size=4>" + GlobalVariables.systemVersion
				+ "<br><br><br></center>"));

		this.add(vp);
	}

}
