package br.com.netflix.testes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.netflix.metodos.Controller;

public class TestaMultiplosAcessos {
	private int row;
	@Before
	public void iniciandoDriver() {
		Controller.passandoCaminhoHttp("https://www.netflix.com/br/login");
	}
	
	@Test
	public void testandoMultiplosUsers() throws Exception {
		for(int i = 1; i < 4; i++) {
			
			boolean conectou = Controller.login(i,1,2);
				
				if(conectou) {					
					row = i;
					break;
				}
				
				Controller.limpar();
		}
	}
	
	@After
	public void finalizacao() throws Exception {
		TestaHomePage.testaHomePage(row);
	}
}
