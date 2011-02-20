package sourceagile.authentication.client;

import sourceagile.client.InternationalizationConstants;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;

/**
 * 
 * @UserManual
 */
public class LanguageOptions extends HorizontalPanel {

	private InternationalizationConstants internationalizationConstants = GWT
			.create(InternationalizationConstants.class);

	public LanguageOptions() {

		this.setWidth("100px");

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		this.setSpacing(5);

		this.add(englishLanguage());

		this.add(portugueseLanguage());

		this.add(spainLanguage());
	}

	private HTML englishLanguage() {

		HTML imageUSA = new HTML("<a href='" + GWT.getModuleBaseURL()
				+ "?locale=en' ><img src='images/USA.jpg' ></a>");

		imageUSA.setTitle(internationalizationConstants.english());

		return imageUSA;
	}

	private HTML portugueseLanguage() {

		HTML imageBrasil = new HTML("<a href='" + GWT.getModuleBaseURL()
				+ "?locale=pt_BR' ><img src='images/Brasil.jpg' ></a>");

		imageBrasil.setTitle(internationalizationConstants.portugues());

		return imageBrasil;
	}

	private HTML spainLanguage() {

		HTML imageEspana = new HTML("<a href='" + GWT.getModuleBaseURL()
				+ "?locale=es'><img src='images/Espana.jpg' ></a>");

		imageEspana.setTitle(internationalizationConstants.espanol());

		return imageEspana;
	}
}
