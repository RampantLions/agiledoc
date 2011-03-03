package jogoDaVelha.client.interfaceComOUsuario;

import helpagile.client.exportation.HelpHint;
import jogoDaVelha.client.VariaveisGlobais;
import jogoDaVelha.shared.EntidadeJogo;

/**
 * No aparecimento de 3 simbolos iguais consecutivos no tabuleiro (horizontal,
 * vertical ou diagonal), o jogador corrente vence, o sistema exibe a sequencia
 * ganhadora em vermelho e o jogo e finalizado.
 * 
 * @MainFeature
 */
public class SequenciaGanhadora {

	public static void showWinner(int currentMoveRow, int currentMoveColumn) {

		String marker = "<font size=7 color=\"red\"><b>"
				+ VariaveisGlobais.statusCorrenteDoJogo.getJogadorCorrente()
						.getSimboloDoJogador() + "</b></font>";

		if (VariaveisGlobais.statusCorrenteDoJogo.getSequenciaGanhadora()
				.equals(EntidadeJogo.SEQUENCE_ROW)) {

			Tabuleiro.gameGrid.setHTML(currentMoveRow, 0, marker);
			Tabuleiro.gameGrid.setHTML(currentMoveRow, 1, marker);
			Tabuleiro.gameGrid.setHTML(currentMoveRow, 2, marker);

		} else if (VariaveisGlobais.statusCorrenteDoJogo
				.getSequenciaGanhadora().equals(EntidadeJogo.SEQUENCE_COLUMN)) {

			Tabuleiro.gameGrid.setHTML(0, currentMoveColumn, marker);
			Tabuleiro.gameGrid.setHTML(1, currentMoveColumn, marker);
			Tabuleiro.gameGrid.setHTML(2, currentMoveColumn, marker);

		} else if (VariaveisGlobais.statusCorrenteDoJogo
				.getSequenciaGanhadora().equals(
						EntidadeJogo.SEQUENCE_DIAGONAL_RIGHT)) {

			Tabuleiro.gameGrid.setHTML(0, 2, marker);
			Tabuleiro.gameGrid.setHTML(1, 1, marker);
			Tabuleiro.gameGrid.setHTML(2, 0, marker);

		} else if (VariaveisGlobais.statusCorrenteDoJogo
				.getSequenciaGanhadora().equals(
						EntidadeJogo.SEQUENCE_DIAGONAL_LEFT)) {

			Tabuleiro.gameGrid.setHTML(0, 0, marker);
			Tabuleiro.gameGrid.setHTML(1, 1, marker);
			Tabuleiro.gameGrid.setHTML(2, 2, marker);
		}

		Tabuleiro.gameGrid.addClickHandler(HelpHint.getClickHandler(
				"tictactoe.client.userInterface.WinningSequence", null,
				"250px", "pt_BR"));
	}

}
