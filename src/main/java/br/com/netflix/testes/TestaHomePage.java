package br.com.netflix.testes;

import br.com.netflix.metodos.Controller;

public class TestaHomePage {

	
	public static void testaHomePage(int row) throws Exception {
		Controller.usuario();
		
		Controller.clicandoEmPesquisar(row);
		
		TestaInicioFilme.testaInicioFilme();
	}
	
}
