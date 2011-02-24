package jogoDaVelha.client;

import helpagile.client.exportation.HelpWindow;
import helpagile.client.utilities.ConvertSpecificationXML;
import jogoDaVelha.client.interfaceComOUsuario.Tabuleiro;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Loading the contents of the help system.
 * 
 * @Architecture
 */
public class InicializacaoDaAjuda {

	public InicializacaoDaAjuda() {

		RequestCallback requestCallback = new RequestCallback() {

			public void onResponseReceived(Request request, Response response) {

				ConvertSpecificationXML.convertHelpEntries(response.getText());

				RootPanel.get("gameBoardHtmlTagId").add(
						HelpWindow.helpIcon("TicTacToe"));

				RootPanel.get("gameBoardHtmlTagId").add(new Tabuleiro());
			}

			public void onError(Request request, Throwable exception) {

				Window.alert("Failed to send the message: "
						+ exception.getMessage());
			}

		};

		helpagile.client.HelpInitialization.initHelp("TicTacToe", null,
				requestCallback);

	}
}
