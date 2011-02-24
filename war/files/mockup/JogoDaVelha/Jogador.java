package jogoDaVelha.shared;

import java.io.Serializable;

/**
 * Information about each player of the game.
 * 
 * @Entity
 */
public class Jogador implements Serializable {

	public static final String PlayerSymbol_X = "X";
	public static final String PlayerSymbol_O = "O";

	private String nome;

	private String email;

	private String simboloDoJogador;

	public String getName() {
		return nome;
	}

	public void setName(String name) {
		this.nome = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSimboloDoJogador() {
		return simboloDoJogador;
	}

	public void setPlayerSymbol(String playerSymbol) {
		this.simboloDoJogador = playerSymbol;
	}

}
