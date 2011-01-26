package sourceagile.authentication.client;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * 
 * @UserManual
 */
public class NewsPanel extends VerticalPanel {

	public NewsPanel() {

		this.setBorderWidth(1);

		VerticalPanel vp = new VerticalPanel();

		vp.setWidth("250px");

		vp.setSpacing(30);

		HTML htmlNewsTitle = new HTML(
				"<font color=blue><b>*** Source Agile NEWS ***</b></font>");

		vp.add(htmlNewsTitle);

		HTML labelNews4 = new HTML(
				"Mon, Jan 24 15:43 <br>Wrapping up for Fullerton Code Camp!");

		vp.add(labelNews4);

		HTML labelNews2 = new HTML(
				"Fri, Jan 21 15:37 <br>Toolkit video comming soon. Stay tuned! ");

		vp.add(labelNews2);

		HTML labelNews1 = new HTML(
				"Fri, Jan 21 10:09<br>Prototype 6 launched this morning. ");

		vp.add(labelNews1);

		HTML labelNews3 = new HTML(
				"Mon, Jan 17 14:20<br>Connect UCSD Springboard is about to incubate the Toolkit. Next meeting scheduled to February, 1st");

		vp.add(labelNews3);

		this.add(vp);
	}
}
