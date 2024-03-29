package sourceagile.authentication.client;

import sourceagile.shared.entities.project.Project;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * 
 * @UserManual
 */
public class BlogArchiveList extends VerticalPanel {

	public BlogArchiveList(String locale) {

		VerticalPanel vpBlog = new VerticalPanel();

		vpBlog.setWidth("550px");

		vpBlog.setSpacing(30);

		vpBlog.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		vpBlog.add(blogTitle(locale));

		if (Project.LOCALE_PORTUGUESE.equals(locale)) {

			showNewsPortuguese(vpBlog);
		} else {

			showNewsEnglish(vpBlog);
		}

		this.add(vpBlog);
	}

	private HTML blogTitle(String locale) {

		String blogLink = "http://livesourceagile.blogspot.com/";
		if (Project.LOCALE_PORTUGUESE.equals(locale)) {

			blogLink = "http://livesourcebrasil.blogspot.com/";
		}

		HTML htmlBlogTitle = new HTML("<font color=orange><b>*** </b></font>"
				+ " <font color=blue><b>LIVE SOURCE BLOG</b></font>"
				+ "<font color=orange><b> ***</b></font><br>" + "<a href='"
				+ blogLink + "' target='_blank'>" + blogLink + "</a><br><br>");

		return htmlBlogTitle;
	}

	private void showNewsEnglish(VerticalPanel vpNews) {

		HTML labelNews7 = new HTML(
				"<a href='http://livesourceagile.blogspot.com/2011/03/being-agile-is-not-easy.html'"
						+ " target='_blank'>Mar 16, 2011 - Being Agile is not Easy</a>");

		vpNews.add(labelNews7);

		HTML labelNews5 = new HTML(
				"<a href='http://livesourceagile.blogspot.com/2011/02/why-some-programmers-dont-like.html'"
						+ " target='_blank'>Feb 10, 2011 - Ubiquitous Language inside the Source Code</a>");

		vpNews.add(labelNews5);

		HTML labelNews6 = new HTML(
				"<a href='http://livesourceagile.blogspot.com/2011/02/ubiquitous-language-inside-source-code.html'"
						+ " target='_blank'>Feb 10, 2011 - Why some programmers don't like transparency</a>");

		vpNews.add(labelNews6);

		HTML labelNews2 = new HTML(
				"<font color=blue>UPCOMING: How to pair programming with a Stakeholder</font>");

		vpNews.add(labelNews2);

		HTML labelNews4 = new HTML(
				"<font color=blue>UPCOMING: The crucial importance of decoupling your source code</font>");

		vpNews.add(labelNews4);

	}

	private void showNewsPortuguese(VerticalPanel vpNews) {

		HTML labelNews7 = new HTML(
				"<a href='http://livesourcebrasil.blogspot.com/2011/03/ser-agil-nao-e-facil.html'"
						+ " target='_blank'>Mar 15, 2011 - Ser Agile n&atilde;o &eacute; f&aacute;cil</a>");

		vpNews.add(labelNews7);

		HTML labelNews5 = new HTML(
				"<a href='http://livesourcebrasil.blogspot.com/2011/02/linguagem-ubiqua-para-dentro-do-codigo.html'"
						+ " target='_blank'>Fev 23, 2011 - Linguagem Ub&iacute;qua para dentro do c&oacute;digo-fonte</a>");

		vpNews.add(labelNews5);

		HTML labelNews6 = new HTML(
				"<a href='http://livesourcebrasil.blogspot.com/2011/02/o-problema-da-comunicacao-no-ambiente.html'"
						+ " target='_blank'>Fev 22, 2011 - O problema da comunica&ccedil;&atilde;o no ambiente de desenvolvimento de software</a>");

		vpNews.add(labelNews6);

		HTML labelNews2 = new HTML(
				"<font color=blue>EM BREVE: Como programar em pares com um Stakeholder</font>");

		vpNews.add(labelNews2);

		HTML labelNews4 = new HTML(
				"<font color=blue>EM BREVE: A import&acirc;ncia crucial do desacoplamento do c&oacute;digo-fonte</font>");

		vpNews.add(labelNews4);

	}
}
