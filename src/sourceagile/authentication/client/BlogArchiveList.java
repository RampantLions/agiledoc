package sourceagile.authentication.client;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * 
 * @UserManual
 */
public class BlogArchiveList extends VerticalPanel {

	public BlogArchiveList() {

		this.setBorderWidth(1);

		VerticalPanel vpBlog = new VerticalPanel();

		vpBlog.setWidth("250px");

		vpBlog.setSpacing(30);

		vpBlog.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		HTML htmlBlogLink = new HTML(
				"<font color=orange><b>*** </b></font>"
						+ " <font color=blue><b>LIVE SOURCE BLOG</b></font>"
						+ "<font color=orange><b> ***</b></font><br>"
						+ "<a href='http://livesourceagile.blogspot.com/' target='_blank'>"
						+ "http://livesourceagile.blogspot.com/</a>");

		vpBlog.add(htmlBlogLink);

		vpBlog.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);

		showNews(vpBlog);

		this.add(vpBlog);
	}

	private void showNews(VerticalPanel vpNews) {

		HTML labelNews5 = new HTML(
				"<a href='http://livesourceagile.blogspot.com/2011/02/why-some-programmers-dont-like.html'"
						+ " target='_blank'>Ubiquitous Language inside the Source Code</a>");

		vpNews.add(labelNews5);

		HTML labelNews6 = new HTML(
				"<a href='http://livesourceagile.blogspot.com/2011/02/ubiquitous-language-inside-source-code.html'"
						+ " target='_blank'>Why some programmers don't like transparency");

		vpNews.add(labelNews6);

		HTML labelNews2 = new HTML(
				"<font color=blue>UPCOMING: How to pair program with a Stakeholder</font>");

		vpNews.add(labelNews2);

		HTML labelNews4 = new HTML(
				"<font color=blue>UPCOMING: The crucial importance of decoupling your source code</font>");

		vpNews.add(labelNews4);

	}
}
