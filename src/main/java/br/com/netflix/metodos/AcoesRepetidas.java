package br.com.netflix.metodos;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AcoesRepetidas {

//	 classe de ações repetidas onde ao inves de escrever a ação, apenas puxamos pelo metodo
	public static void escrever(String texto, WebElement element) {
		element.sendKeys(texto);		
	}

	public static void clicar(WebElement element) {
		element.click();		
	}
	public static void pararEmCimaDoElemento(Actions actions, WebElement element) {
		actions.moveToElement(element).perform();
	}
	
	public static void close() {
		Criar.close();		
	}

	public static void limpar(WebElement element) {
		element.clear();		
	}

}
