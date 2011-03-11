package jogoDaVelha.server;

import jogoDaVelha.GameEntityTest;
import jogoDaVelha.PlayersTest;
import jogoDaVelha.shared.EntidadeJogo;
import junit.framework.TestCase;

/**
 * Test Class for: JulgamentoDoMovimento. Verifica se o movimento do jogador
 * executou uma seqüência ganhadora ou não.
 * 
 */
public class JulgamentoDoMovimentoTest extends TestCase {

	public void testCheckForWinner_Loose() {

		int currentMoveRow = 1;

		int currentMoveColumn = 2;

		EntidadeJogo gameEntity = GameEntityTest.returnGameEntity();

		gameEntity.getMovimentosNoJogo()[currentMoveRow][currentMoveColumn] = PlayersTest
				.returnPlayerO();

		EntidadeJogo checkForWinnerTested = JulgamentoDoMovimento
				.checkForWinner(gameEntity, currentMoveRow, currentMoveColumn);

		assertEquals(checkForWinnerTested, null);
	}

	public void testCheckForWinner_Win() {

		EntidadeJogo gameEntity = GameEntityTest.returnGameEntity();

		int currentMoveRow = 2;

		int currentMoveColumn = 2;

		gameEntity.getMovimentosNoJogo()[currentMoveRow][currentMoveColumn] = PlayersTest
				.returnPlayerX();

		EntidadeJogo checkForWinnerTested = JulgamentoDoMovimento
				.checkForWinner(gameEntity, currentMoveRow, currentMoveColumn);

		assertEquals(checkForWinnerTested, EntidadeJogo.SEQUENCE_DIAGONAL_LEFT);
	}

}
