package jogoDaVelha.client.arquitetura;

import jogoDaVelha.shared.EntidadeJogo;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("infraestrutura")
public interface InterfaceComOServidor extends RemoteService {

	EntidadeJogo checkForWinner(EntidadeJogo currentGame, int currentMoveRow,
			int currentMoveColumn);

}
