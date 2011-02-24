package jogoDaVelha.client.arquitetura;

import jogoDaVelha.client.VariaveisGlobais;
import jogoDaVelha.client.interfaceComOUsuario.MovimentoDoJogador;
import jogoDaVelha.client.interfaceComOUsuario.SequenciaGanhadora;
import jogoDaVelha.shared.EntidadeJogo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class ChamadaParaOJulgamentoDoMovimento {

	/**
	 * Create a remote service proxy to talk to the server-side Greeting
	 * service.
	 */
	private static final InterfaceComOServidorAsync greetingService = GWT
			.create(InterfaceComOServidor.class);

	public static void verificaSeGanhou(EntidadeJogo currentGame,
			final int currentMoveRow, final int currentMoveColumn) {

		greetingService.checkForWinner(currentGame, currentMoveRow,
				currentMoveColumn, new AsyncCallback<EntidadeJogo>() {

					public void onSuccess(EntidadeJogo gameReturned) {

						if (gameReturned.getSequenciaGanhadora() != null) {

							VariaveisGlobais.statusCorrenteDoJogo
									.setSequenceWinner(gameReturned
											.getSequenciaGanhadora());

							SequenciaGanhadora.showWinner(currentMoveRow,
									currentMoveColumn);
						} else {

							MovimentoDoJogador.inverterJogadorCorrente();
						}
					}

					public void onFailure(Throwable caught) {

						Window.alert(caught.toString());
					}
				});

	}

}
