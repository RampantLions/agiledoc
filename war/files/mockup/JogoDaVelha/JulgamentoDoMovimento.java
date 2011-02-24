package jogoDaVelha.server;

import jogoDaVelha.shared.EntidadeJogo;
import jogoDaVelha.shared.Jogador;

/**
 * Verifica se o movimento do jogador executou uma seqüência ganhadora ou não.
 * 
 */
public class JulgamentoDoMovimento {

	public static EntidadeJogo checkForWinner(EntidadeJogo currentGame,
			int currentMoveRow, int currentMoveColumn) {

		String sequenceWinner = null;

		Jogador currentPlayer = currentGame.getMovimentosNoJogo()[currentMoveRow][currentMoveColumn];

		if (currentPlayer != null) {

			if (checkWinnerRow(currentGame, currentPlayer, currentMoveRow)) {

				sequenceWinner = EntidadeJogo.SEQUENCE_ROW;

			} else if (checkWinnerColumn(currentGame, currentPlayer,
					currentMoveColumn)) {

				sequenceWinner = EntidadeJogo.SEQUENCE_COLUMN;

			} else if (checkWinnerDiagonalRight(currentGame, currentPlayer)) {

				sequenceWinner = EntidadeJogo.SEQUENCE_DIAGONAL_RIGHT;

			} else if (checkWinnerDiagonalLeft(currentGame, currentPlayer)) {

				sequenceWinner = EntidadeJogo.SEQUENCE_DIAGONAL_LEFT;
			}
		}

		currentGame.setSequenceWinner(sequenceWinner);

		return currentGame;
	}

	private static boolean checkWinnerRow(EntidadeJogo currentGame,
			Jogador currentPlayer, int currentMoveRow) {

		String currentPlayerIcon = currentPlayer.getSimboloDoJogador();

		if (currentGame.getMovimentosNoJogo()[currentMoveRow][0] != null
				&& currentGame.getMovimentosNoJogo()[currentMoveRow][1] != null
				&& currentGame.getMovimentosNoJogo()[currentMoveRow][2] != null
				&& currentPlayerIcon
						.equals(currentGame.getMovimentosNoJogo()[currentMoveRow][0]
								.getSimboloDoJogador())
				&& currentPlayerIcon
						.equals(currentGame.getMovimentosNoJogo()[currentMoveRow][1]
								.getSimboloDoJogador())
				&& currentPlayerIcon
						.equals(currentGame.getMovimentosNoJogo()[currentMoveRow][2]
								.getSimboloDoJogador())) {

			return true;
		}

		return false;
	}

	private static boolean checkWinnerColumn(EntidadeJogo currentGame,
			Jogador currentPlayer, int currentMoveColumn) {

		String currentPlayerIcon = currentPlayer.getSimboloDoJogador();

		if (currentGame.getMovimentosNoJogo()[0][currentMoveColumn] != null
				&& currentGame.getMovimentosNoJogo()[1][currentMoveColumn] != null
				&& currentGame.getMovimentosNoJogo()[2][currentMoveColumn] != null
				&& currentPlayerIcon
						.equals(currentGame.getMovimentosNoJogo()[0][currentMoveColumn]
								.getSimboloDoJogador())
				&& currentPlayerIcon
						.equals(currentGame.getMovimentosNoJogo()[1][currentMoveColumn]
								.getSimboloDoJogador())
				&& currentPlayerIcon
						.equals(currentGame.getMovimentosNoJogo()[2][currentMoveColumn]
								.getSimboloDoJogador())) {

			return true;
		}

		return false;
	}

	private static boolean checkWinnerDiagonalRight(EntidadeJogo currentGame,
			Jogador currentPlayer) {

		String currentPlayerIcon = currentPlayer.getSimboloDoJogador();

		if (currentGame.getMovimentosNoJogo()[0][2] != null
				&& currentGame.getMovimentosNoJogo()[1][1] != null
				&& currentGame.getMovimentosNoJogo()[2][0] != null
				&& currentPlayerIcon.equals(currentGame.getMovimentosNoJogo()[0][2]
						.getSimboloDoJogador())
				&& currentPlayerIcon.equals(currentGame.getMovimentosNoJogo()[1][1]
						.getSimboloDoJogador())
				&& currentPlayerIcon.equals(currentGame.getMovimentosNoJogo()[2][0]
						.getSimboloDoJogador())) {

			return true;
		}

		return false;
	}

	private static boolean checkWinnerDiagonalLeft(EntidadeJogo currentGame,
			Jogador currentPlayer) {

		String currentPlayerIcon = currentPlayer.getSimboloDoJogador();

		if (currentGame.getMovimentosNoJogo()[0][0] != null
				&& currentGame.getMovimentosNoJogo()[1][1] != null
				&& currentGame.getMovimentosNoJogo()[2][2] != null
				&& currentPlayerIcon.equals(currentGame.getMovimentosNoJogo()[0][0]
						.getSimboloDoJogador())
				&& currentPlayerIcon.equals(currentGame.getMovimentosNoJogo()[1][1]
						.getSimboloDoJogador())
				&& currentPlayerIcon.equals(currentGame.getMovimentosNoJogo()[2][2]
						.getSimboloDoJogador())) {

			return true;

		}

		return false;
	}
}
