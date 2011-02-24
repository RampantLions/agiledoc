package jogoDaVelha.client.arquitetura;

import jogoDaVelha.shared.EntidadeJogo;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Interface Assíncrona para o servidor de Infra-estrutura do sistema.
 */
public interface InterfaceComOServidorAsync {

	void checkForWinner(EntidadeJogo currentGame, int currentMoveRow,
			int currentMoveColumn, AsyncCallback<EntidadeJogo> asyncCallback);
}
