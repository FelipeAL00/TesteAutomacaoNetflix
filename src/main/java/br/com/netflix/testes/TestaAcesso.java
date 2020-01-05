package br.com.netflix.testes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.netflix.metodos.Controller;

public class TestaAcesso {
	@Before
	public void iniciandoDriver() {
		Controller.passandoCaminhoHttp("https://www.netflix.com/br/login");
	}
	
	@Test
	public void testaAcesso() throws Exception {
		Controller.login(1,1,2); 
	}
	
	@After
	public void entrarHome() throws Exception {
		TestaHomePage.testaHomePage(1);
		
		Controller.close();
	}
	
}
