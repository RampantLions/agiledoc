package jogoDaVelha.server;

import jogoDaVelha.client.arquitetura.InterfaceComOServidor;
import jogoDaVelha.shared.EntidadeJogo;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 * 
 * @Architecture
 */
@SuppressWarnings("serial")
public class InterfaceComOServidorImpl extends RemoteServiceServlet implements
		InterfaceComOServidor {

	@Override
	public EntidadeJogo checkForWinner(EntidadeJogo currentGame,
			int currentMoveRow, int currentMoveColumn) {

		return JulgamentoDoMovimento.checkForWinner(currentGame,
				currentMoveRow, currentMoveColumn);
	}

}
