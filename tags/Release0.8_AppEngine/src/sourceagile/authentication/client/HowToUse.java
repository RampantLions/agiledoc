package sourceagile.authentication.client;

import helpagile.client.exportation.HelpWindow;
import sourceagile.client.GlobalVariables;
import sourceagile.client.InternationalizationConstants;
import sourceagile.shared.entities.project.Project;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * 
 * @UserManual
 */
public class HowToUse extends VerticalPanel {

	private InternationalizationConstants internationalizationConstants = GWT
			.create(InternationalizationConstants.class);

	public HowToUse(String locale) {

		this.setBorderWidth(1);

		VerticalPanel vpBlog = new VerticalPanel();

		vpBlog.setWidth("300px");

		vpBlog.setSpacing(30);

		vpBlog.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		vpBlog.add(showTitle());

		vpBlog.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);

		if (Project.LOCALE_PORTUGUESE.equals(locale)) {

			vpBlog.add(howToUsePortuguese());
		} else {

			vpBlog.add(howToUseEnglish());
		}

		vpBlog.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);

		vpBlog.add(HelpWindow.helpLink("LiveSource", "false", null,
				internationalizationConstants.readMore(),
				GlobalVariables.locale));

		this.add(vpBlog);
	}

	private HTML showTitle() {

		HTML htmlBlogTitle = new HTML("<font color=orange><b>*** </b></font>"
				+ " <font color=blue><b>"
				+ internationalizationConstants.howToUse() + "</b></font>"
				+ "<font color=orange><b> ***</b></font><br>");

		return htmlBlogTitle;
	}

	private HTML howToUseEnglish() {

		HTML html = new HTML(
				"<br> Select the project you want to manage "
						+ "   and type the user name and password you use "
						+ "   to access the remote file repository of the project you selected."
						+ "<br><br> Or you can play with our Tic Tac Toe DEMO project typing your email."
						+ "   You don't need to type a password to access the Demo project.");

		return html;
	}

	private HTML howToUsePortuguese() {

		HTML html = new HTML(
				"<br> Selecione o projeto que voc&ecirc; deseja gerenciar "
						+ "   e depois digite o seu nome de usu&aacute;rio e senha de acesso "
						+ "   ao reposit&oacute;rio remote de arquivos do projeto selecionado."
						+ "<br><br> Ou ent&atilde;o utilize a vontade o projeto Jogo da Velha DEMO"
						+ " digitando o seu email no campo usu&aacute;rio. "
						+ "   N&atilde;o &eacute; necess&aacute;rio senha para acessar o projeto DEMO.");

		return html;
	}
}
