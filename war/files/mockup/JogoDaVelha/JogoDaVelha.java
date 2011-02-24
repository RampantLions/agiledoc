package jogoDaVelha.client;

import com.google.gwt.core.client.EntryPoint;

/**
 * Classe âncora para inicialização do sistema pelo Google Web Toolkit
 * (EntryPoint).
 * 
 * @Architecture
 */
public class JogoDaVelha implements EntryPoint {

	public void onModuleLoad() {

		new InicializacaoDoJogo();

		new InicializacaoDaAjuda();
	}

}
