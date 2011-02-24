package jogoDaVelha.client.interfaceComOUsuario;

import helpagile.client.exportation.HelpHint;

import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * The web page where the game is shown. Accommodates the game grid and also
 * some options such as a restart button, help, game score, game status, ...
 */
public class Tabuleiro extends VerticalPanel {

	public static GradeDoJogo gameGrid = new GradeDoJogo();

	public Tabuleiro() {

		this.setSize("100%", "100%");

		this.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		this.add(gameGrid);

		this.setTitle(HelpHint.getHelpHint(this.getClass()));
	}

}
