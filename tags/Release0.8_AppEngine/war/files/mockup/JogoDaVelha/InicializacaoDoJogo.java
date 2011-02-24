package jogoDaVelha.client;

import jogoDaVelha.shared.Jogador;

public class InicializacaoDoJogo {

	public InicializacaoDoJogo() {

		VariaveisGlobais.playerO.setPlayerSymbol(Jogador.PlayerSymbol_O);

		VariaveisGlobais.playerX.setPlayerSymbol(Jogador.PlayerSymbol_X);

		VariaveisGlobais.statusCorrenteDoJogo
				.setCurrentPlayer(VariaveisGlobais.playerX);

		VariaveisGlobais.statusCorrenteDoJogo.setMovimentosNoJogo(new Jogador[3][3]);
	}
}
