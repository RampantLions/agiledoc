package jogoDaVelha.client.interfaceComOUsuario;

import jogoDaVelha.client.VariaveisGlobais;
import jogoDaVelha.client.arquitetura.ChamadaParaOJulgamentoDoMovimento;
import jogoDaVelha.shared.Jogador;

import com.google.gwt.user.client.ui.HTMLTable.Cell;

/**
 * Efetiva o movimento do jogador na grade do jogo.
 * 
 * @Feature
 */
public class MovimentoDoJogador {

	/**
	 * Quando o jogador clica numa celula na grade do tabuleiro o jogo desenha
	 * um 0 ou X dependendo de qual e o jogador atual.
	 */
	public static void mover(GradeDoJogo gradeDoJogo, Cell celulaSelecionada) {

		if (!VariaveisGlobais.flagDeAguardoDoMovimento
				&& VariaveisGlobais.statusCorrenteDoJogo.getSequenciaGanhadora() == null
				&& eCelulaVazia(gradeDoJogo, celulaSelecionada)) {

			VariaveisGlobais.flagDeAguardoDoMovimento = true;

			String simbolo = exibeSimboloDoJogador(VariaveisGlobais.statusCorrenteDoJogo
					.getJogadorCorrente().getSimboloDoJogador());

			gradeDoJogo.setHTML(celulaSelecionada.getRowIndex(),
					celulaSelecionada.getCellIndex(), simbolo);

			VariaveisGlobais.statusCorrenteDoJogo.getMovimentosNoJogo()[celulaSelecionada
					.getRowIndex()][celulaSelecionada.getCellIndex()] = VariaveisGlobais.statusCorrenteDoJogo
					.getJogadorCorrente();

			ChamadaParaOJulgamentoDoMovimento.verificaSeGanhou(
					VariaveisGlobais.statusCorrenteDoJogo,
					celulaSelecionada.getRowIndex(),
					celulaSelecionada.getCellIndex());
		}
	}

	/**
	 * Um jogador podera selecionar somente as celulas que ainda nao foram
	 * selecionadas.
	 */
	private static boolean eCelulaVazia(GradeDoJogo gameGrid, Cell cell) {

		Jogador cellPlayer = VariaveisGlobais.statusCorrenteDoJogo.getMovimentosNoJogo()[cell
				.getRowIndex()][cell.getCellIndex()];

		return (cellPlayer == null);
	}

	/**
	 * Exibe o simbolo correto do jogador corrente na grade do jogo.
	 */
	private static String exibeSimboloDoJogador(String playerSymbol) {

		String symbolColor = "darkgreen";
		if (playerSymbol.equals(VariaveisGlobais.playerO.getSimboloDoJogador())) {

			symbolColor = "darkblue";
		}

		String symbol = "<font size=6 color=" + symbolColor + "><b>"
				+ playerSymbol + "</b></font>";

		return symbol;
	}

	public static void inverterJogadorCorrente() {

		if (VariaveisGlobais.statusCorrenteDoJogo.getJogadorCorrente()
				.getSimboloDoJogador().equals(Jogador.PlayerSymbol_X))
			VariaveisGlobais.statusCorrenteDoJogo
					.setCurrentPlayer(VariaveisGlobais.playerO);

		else if (VariaveisGlobais.statusCorrenteDoJogo.getJogadorCorrente()
				.getSimboloDoJogador().equals(Jogador.PlayerSymbol_O))
			VariaveisGlobais.statusCorrenteDoJogo
					.setCurrentPlayer(VariaveisGlobais.playerX);

		VariaveisGlobais.flagDeAguardoDoMovimento = false;
	}

}
