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

		VerticalPanel vpNews = new VerticalPanel();

		vpNews.setWidth("250px");

		vpNews.setSpacing(30);

		HTML htmlNewsTitle = new HTML(
				"<font color=blue><b>*** Live Source NEWS ***</b></font>");

		vpNews.add(htmlNewsTitle);

		showNews(vpNews);

		this.add(vpNews);
	}

	private void showNews(VerticalPanel vpNews) {

		HTML labelNews5 = new HTML(
				"Qua, Feb 2 13:45 <br>DEMO software live on Google Cloud! Big step! ");

		vpNews.add(labelNews5);

		HTML labelNews6 = new HTML(
				"Seg, Jan 31 17:11 <br>Ideas comming up for a new Blog for the system... ");

		vpNews.add(labelNews6);

		HTML labelNews2 = new HTML(
				"Fri, Jan 28 21:37 <br>Toolkit video available on youtube. Stay tuned! ");

		vpNews.add(labelNews2);

		HTML labelNews4 = new HTML(
				"Mon, Jan 24 15:43 <br>Wrapping up for Fullerton Code Camp!");

		vpNews.add(labelNews4);

	}

	private void showOlds(VerticalPanel vpNews) {

		HTML labelNews1 = new HTML(
				"Fri, Jan 21 10:09<br>Prototype 6 launched this morning. ");

		vpNews.add(labelNews1);

		HTML labelNews3 = new HTML(
				"Mon, Jan 17 14:20<br>Connect UCSD Springboard is about to incubate the Toolkit. Next meeting scheduled to February, 1st");

		vpNews.add(labelNews3);
	}
}