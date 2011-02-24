package jogoDaVelha.shared;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @Entity
 */
public class EntidadeJogo implements Serializable {

	public static final String SEQUENCE_ROW = "row";
	public static final String SEQUENCE_COLUMN = "column";
	public static final String SEQUENCE_DIAGONAL_RIGHT = "diagonalRight";
	public static final String SEQUENCE_DIAGONAL_LEFT = "diagonalLeft";

	private Date data;

	private Jogador[][] movimentosNoJogo;

	private Jogador jogadorCorrente;

	private String sequenciaGanhadora;

	public Date getDate() {
		return data;
	}

	public void setDate(Date date) {
		this.data = date;
	}

	public Jogador[][] getMovimentosNoJogo() {
		return movimentosNoJogo;
	}

	public void setMovimentosNoJogo(Jogador[][] gameMoves) {
		this.movimentosNoJogo = gameMoves;
	}

	public Jogador getJogadorCorrente() {
		return jogadorCorrente;
	}

	public void setCurrentPlayer(Jogador currentPlayer) {
		this.jogadorCorrente = currentPlayer;
	}

	public String getSequenciaGanhadora() {
		return sequenciaGanhadora;
	}

	public void setSequenceWinner(String sequenceWinner) {
		this.sequenciaGanhadora = sequenceWinner;
	}

}
