package jogoDaVelha.client.interfaceComOUsuario;

import helpagile.client.exportation.HelpHint;

import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;





/** 
 * Acomoda a grade do jogo na pagina web. Tambem acomoda outros componentes como link para o sistema de ajuda, botao de reestartar o jogo, placar, ...
O tabuleiro e exibido assim que o jogo se inicia.
 * 
 * @MainFeature 
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
